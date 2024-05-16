/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirynt.readers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
    private final  ArrayList<ArrayList<Cell>> cells = new ArrayList();
    private int subListMaxSize;
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
        int rows = (readTwoBytesToInt(inputStream)-1)/2 ;
        mazeData.setRows(rows);
        subListMaxSize = mazeData.getColumns()*2+1;
    }

    private void readFileId(InputStream inputStream) throws IOException {
        inputStream.skip(5);
    }

    private void readEntryAndExit(InputStream inputStream, MazeData mazeData) throws IOException{
        int entryX = readTwoBytesToInt(inputStream);
        int entryY = readTwoBytesToInt(inputStream);
        int exitX = readTwoBytesToInt(inputStream);
        int exitY = readTwoBytesToInt(inputStream);
        int start = ((entryY/2)-1)*mazeData.getColumns() + (entryX/2) + 1;
        int end = ((exitY/2)-1)*mazeData.getColumns() + (exitX/2);
        mazeData.setStart(start);
        mazeData.setEnd(end);
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
        inputStream.skip(7);
        int value, count;
        for(int i = 0; i <= counter; i++){   
            inputStream.read();
            value = inputStream.read();
            count = inputStream.read();
            switch(value){
                    case ' ' -> addToMazeCells(Cell.PATH, count);
                    case 'X' ->  addToMazeCells(Cell.WALL, count);
            }
        }
        cells.add(subList);
        mazeData.setMazeCells((List)cells);
         System.out.print(cells.size());
    }

    private void addToMazeCells(Cell value, int cellsToAdd) {
        while(cellsToAdd != -1){
            if(subList.size() < subListMaxSize){
                subList.add(value);
            }
            else {
                cells.add(subList);
                subList = new ArrayList<>();
                subList.add(value);
            }
            cellsToAdd--;
        }
    }
}
