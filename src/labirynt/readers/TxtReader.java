/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirynt.readers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import labirynt.Cell;
import labirynt.MazeData;

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
        int columns = 0;
        try(FileInputStream fin=new FileInputStream(filePath))
        {    
            int i;
            boolean nextIsStart = false;
            ArrayList<Cell> subList = new ArrayList<>() ; 
            while((i=fin.read())!=-1){
                switch(i){
                    case '\n' -> {
                        cells.add(subList);
                        columns = subList.size()/2;
                        subList = new ArrayList<>();
                    }
                    case ' ' -> {
                        if(nextIsStart){
                            subList.add(Cell.START);
                            nextIsStart = false;
                        }
                        else
                            subList.add(Cell.PATH);
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
            fin.close();
        }
        catch(IOException ex){
           
            System.out.println(ex.getMessage());
        }
       
    
    
    }
    
    
    
}
