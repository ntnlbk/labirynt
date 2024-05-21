/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirynt.readers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import labirynt.AdjacencyMatrix;
import labirynt.Cell;
import labirynt.MazeData;
import labirynt.Passage;

/**
 *
 * @author Anton
 */
public class TxtReader implements MazeReader {
    
    private final String filePath;
    
    public TxtReader(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void readFromFile(MazeData mazeData) {
        ArrayList<ArrayList<Cell>> cells = new ArrayList();
        mazeData.setAdjacencyMatrix(null);
        AdjacencyMatrix matrix = new AdjacencyMatrix();
        int columns = 0;
        try(FileInputStream fin=new FileInputStream(filePath))
        {    
            int i;
            boolean nextIsStart = false;
            ArrayList<Cell> subList = new ArrayList<>() ; 
            while((i=fin.read())!=-1){
                switch(i){
                    case '\n' -> {
                        if (cells.isEmpty()){
                            columns = subList.size()/2;
                            matrix.setColumns(columns);
                        }
                        cells.add(subList);
                        subList = new ArrayList<>();
                    }
                    case ' ' -> {
                        if(nextIsStart){
                            subList.add(Cell.START);
                            nextIsStart = false;
                        }
                        else
                            subList.add(Cell.PATH);
                        if(cells.size() % 2 == 1 && subList.size() % 2 == 1){
                            int node = countNode(columns, cells, subList);
                            matrix.addPath(node+1, Passage.LEFT);
                            matrix.addPath(node, Passage.RIGHT);
                        } 
                        if (cells.size() % 2 == 0 && subList.size() % 2 == 0 && !cells.isEmpty() && !subList.isEmpty()){
                            matrix.addPath(countNode(columns, cells, subList), Passage.BOTTOM);
                            matrix.addPath(countNode(columns, cells, subList)+columns, Passage.TOP);
                        }
                        
                    }
                    case 'X' -> subList.add(Cell.WALL);
                    case 'P' -> {
                        int node = columns * ((cells.size()+1)/2 - 1)  + subList.size()/2;
                        subList.add(Cell.WALL);
                        mazeData.setStart(node);
                        nextIsStart = true;
                        
                        }
                    case 'K' -> {
                        int node = columns * ((cells.size()+1)/2 - 1)  + subList.size()/2 - 1;
                        mazeData.setEnd(node);
                        subList.add(Cell.WALL);
                        subList.set(subList.size()-2, Cell.END);
                    }
                }
            } 
            mazeData.setMazeCells((List)cells);
            mazeData.setColumns((cells.get(0).size() - 1) / 2);
            mazeData.setRows((cells.size() - 1) / 2);
            mazeData.setAdjacencyMatrix(matrix);
            fin.close();
        }
        catch(IOException ex){
           
            System.out.println(ex.getMessage());
        }
       
    
    
    }

    private int countNode(int columns, ArrayList<ArrayList<Cell>> cells, ArrayList<Cell> subList) {
        int node = columns * ((cells.size()+1)/2 - 1)  + subList.size()/2;
        return node-1;
    }
    
    
    
}
