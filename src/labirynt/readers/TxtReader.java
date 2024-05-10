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
    
    private String filePath;
    
    public TxtReader(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void readFromFile(MazeData mazeData) {
        ArrayList<ArrayList<Cell>> cells = new ArrayList();
        try(FileInputStream fin=new FileInputStream(filePath))
        {    
            int i;
            ArrayList<Cell> subList = new ArrayList<>() ; 
            while((i=fin.read())!=-1){
                switch(i){
                    case '\n' -> {
                        cells.add(subList);
                        subList = new ArrayList<>();
                    }
                    case ' ' -> subList.add(Cell.PATH);
                    case 'X' -> subList.add(Cell.WALL);
                    case 'P' -> subList.add(Cell.START);
                    case 'K' -> subList.add(Cell.END);
                }
                
            } 
            mazeData.mazeCells = (List)cells;
            fin.close();
        }
        catch(IOException ex){
           
            System.out.println(ex.getMessage());
        }
       
    
    
    }
    
}
