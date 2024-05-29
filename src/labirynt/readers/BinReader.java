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
//import labirynt.AdjacencyMatrix;
import labirynt.Cell;
import labirynt.MazeData;
import labirynt.Passage;

/**
 *
 * @author Anton
 */
public class BinReader{
    
    private final String filePath;
    private ArrayList<Cell> subList = new ArrayList<>() ; 
    private final  ArrayList<ArrayList<Cell>> cells = new ArrayList();
    private int columns;
    private int rows;
    private int subListMaxSize;
    
    public BinReader(String filePath){
        this.filePath = filePath;
    }

    public void readFromFile(MazeData mazeData) {
        try {
            InputStream inputStream = new FileInputStream(filePath);
            mazeData.setAdjacencyMatrix(null);
            mazeData.initAdjacencyMatrix();
            readFileId(inputStream);
            readRowsAndColumns(inputStream, mazeData) ;
            readEntryAndExit(inputStream, mazeData);
            readMaze(inputStream, mazeData);
            updateStartCellType(mazeData);
            updateEndCellType(mazeData);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BinReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BinReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void readRowsAndColumns(InputStream inputStream, MazeData mazeData) throws IOException {
        columns = (readTwoBytesToInt(inputStream)-1)/2 ;
        mazeData.setColumns(columns);
        rows = (readTwoBytesToInt(inputStream)-1)/2 ;
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
        int start = ((entryY/2)-1)*mazeData.getColumns() + (entryX/2);
        int end = ((exitY/2)-1)*mazeData.getColumns() + (exitX/2)-1;
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
                    case ' ' -> addToMazeCells(Cell.SPACE, count, mazeData);
                    case 'X' ->  addToMazeCells(Cell.WALL, count, mazeData);
            }
        }
        cells.add(subList);
        mazeData.setMazeCells((List)cells);
    }

    private void addToMazeCells(Cell value, int cellsToAdd, MazeData mazeData) {
        while(cellsToAdd != -1){
            if(subList.size() < subListMaxSize){
                subList.add(value);
            }
            else {
                cells.add(subList);
                subList = new ArrayList<>();
                subList.add(value);
            }
            if(value == Cell.SPACE){
                if(cells.size() % 2 == 1 && subList.size() % 2 == 1){
                    int node = countNode(columns, cells, subList);
                        mazeData.addPathToMatrix(node+1, Passage.LEFT);
                        if(node != rows * columns - 1)
                            mazeData.addPathToMatrix(node, Passage.RIGHT);
                } 
                if (cells.size() % 2 == 0 && subList.size() % 2 == 0 && !cells.isEmpty() && !subList.isEmpty()){
                    mazeData.addPathToMatrix(countNode(columns, cells, subList), Passage.BOTTOM);
                    mazeData.addPathToMatrix(countNode(columns, cells, subList)+columns, Passage.TOP);
                    }
                }
            cellsToAdd--;
        }
    }
    
    private void updateStartCellType(MazeData mazeData) {
        int startNode= mazeData.getStart();
        updateCellType(mazeData, Cell.START, startNode);
    }
    
    private void updateEndCellType(MazeData mazeData) {
        int endNode= mazeData.getEnd();
        updateCellType(mazeData, Cell.END, endNode);
        
    }
    
    private void updateCellType(MazeData mazeData, Cell type, int node ){
        int nodeY = node/mazeData.getColumns();
        int nodeX = node -nodeY*mazeData.getColumns();
        mazeData.setCellType(type, nodeX*2+1, nodeY*2+1);
        if (type == Cell.START)
            mazeData.setCellType(Cell.WALL, nodeX*20, nodeY*2+1);
        if (type == Cell.END)
            mazeData.setCellType(Cell.WALL, nodeX*2+2, nodeY*2+1);
    }
    
    private int countNode(int columns, ArrayList<ArrayList<Cell>> cells, ArrayList<Cell> subList) {
        int node = columns * ((cells.size()+1)/2 - 1)  + subList.size()/2;
        return node-1;
    }
}
