/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirynt.readers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import labirynt.Cell;
import labirynt.MazeData;

/**
 *
 * @author Anton
 */
public class BinReader implements MazeReader{
    
    private final String filePath;
    private ArrayList<Cell> subList = new ArrayList<>() ; 
    private  ArrayList<ArrayList<Cell>> cells = new ArrayList();
    public BinReader(String filePath){
        this.filePath = filePath;
       
    }

    @Override
    public void readFromFile(MazeData mazeData) {
        try {
            InputStream inputStream = new FileInputStream(filePath);
            readFileId(inputStream) ;
            readRowsAndColumns(inputStream, mazeData) ;
            readEntryAndExit(inputStream, mazeData);
            readMaze(inputStream, mazeData);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BinReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BinReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void readRowsAndColumns(InputStream inputStream, MazeData mazeData) throws IOException {
        int columns = (readTwoBytesToInt(inputStream)-1)/2 ;
        mazeData.setColumns(columns);
        System.out.print("columns: " + columns + "\n");
        int rows = (readTwoBytesToInt(inputStream)-1)/2 ;
        mazeData.setRows(rows);
        System.out.print("rows: " + rows + "\n");
    }

    private void readFileId(InputStream inputStream) throws IOException {
        inputStream.skip(5);
    }

    private void readEntryAndExit(InputStream inputStream, MazeData mazeData) throws IOException{
        int entryX = readTwoBytesToInt(inputStream);
        System.out.print("entryX: " + entryX + "\n");
        int entryY = readTwoBytesToInt(inputStream);
        System.out.print("entryY: " + entryY + "\n");
        int exitX = readTwoBytesToInt(inputStream);
        System.out.print("exitX: " + exitX + "\n");
        int exitY = readTwoBytesToInt(inputStream);
        System.out.print("exitY: " + exitY + "\n");
        int start = ((entryY/2)-1)*mazeData.getColumns() + (entryX/2) + 1;
        int end = ((exitY/2)-1)*mazeData.getColumns() + (exitX/2);
        mazeData.setStart(start);
        mazeData.setEnd(end);
        System.out.print("start: " + start + "\nend: " + end + "\n");
    }
    
    private int readTwoBytesToInt(InputStream inputStream) throws IOException {
        byte[]  byteRead = inputStream.readNBytes(2) ;
        return  byteRead[0] | byteRead[1] << 8;
    }
    private int readFourBytesToInt(InputStream inputStream) throws IOException {
        byte[]  byteRead = inputStream.readNBytes(4) ;
        return  byteRead[0] | byteRead[1] << 8 | byteRead[2] << 16 | byteRead[3] << 24;
    }

    private void readMaze(InputStream inputStream, MazeData mazeData) throws IOException {
        inputStream.skip(12);
        int counter = readFourBytesToInt(inputStream);
        System.out.print("counter: " + counter + "\n");
        inputStream.skip(4);
        int separator = inputStream.read();
        int wall = inputStream.read();
        int path = inputStream.read();
        int value, count;
           int subListMaxSize = mazeData.getColumns()*2+1;

        System.out.print("separator: " + (char)separator + "\nwall: " +(char) wall + "\npath: " + (char)path);
        for(int i = 0; i <= counter; i++){   
            inputStream.read();
            value = inputStream.read();
            count = inputStream.read();
            
            switch(value){
                    case ' ' -> addToMazeCells(Cell.PATH, count, subListMaxSize);
           
                    case 'X' ->  addToMazeCells(Cell.WALL, count, subListMaxSize);
            }
        }
        cells.add(subList);
        mazeData.setMazeCells((List)cells);
         System.out.print(cells.size());
    }

    private void addToMazeCells(Cell value, int cellsToAdd, int subListMaxSize) {
        
        while(cellsToAdd != -1){
            if(subList.size() < subListMaxSize){
                 //System.out.print(value);
                subList.add(value);
            }
            else {
                 //System.out.print(subList.size() + " ");
                cells.add(subList);
                
                 subList = new ArrayList<>();
                subList.add(value);
            }
            cellsToAdd--;
        }
    }
}
