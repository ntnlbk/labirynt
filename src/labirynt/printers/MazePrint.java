/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirynt.printers;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.List;
import labirynt.Cell;

/**
 *
 * @author Admin
 */
public class MazePrint extends JPanel{
    
    private final int SQUARE_SIZE = 10;
    
    private final List<List<Cell>> cells;
    
    public MazePrint(List<List<Cell>> cells){
        this.cells=cells;
        setBackground(Color.white);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        if(cells!=null){
            for(int row =0; row<cells.size(); row++){
                List<Cell> rowCells = cells.get(row);
                for(int col = 0; col < rowCells.size(); col++){
                    Cell cell = rowCells.get(col);
                    switch (cell){
                        case WALL -> g.setColor(Color.black);
                        default -> g.setColor(Color.white);
                    }
                    g.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                }
            }
        }
     
    }
    
}
