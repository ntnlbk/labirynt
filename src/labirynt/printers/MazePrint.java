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
import labirynt.MazeData;

/**
 *
 * @author Admin
 */
public class MazePrint extends JPanel{
    
    private final int SQUARE_SIZE = 10;
    
    private final Color WALL_COLOR = Color.BLACK;
    
    private final Color PATH_COLOR = Color.WHITE;
    
    private final List<List<Cell>> cells;
    
    private final MazeData mazeData;
    
    public int getSquareSize(){
        return SQUARE_SIZE;
    }
    
    public MazePrint(MazeData mazeData){
        this.mazeData = mazeData;
        this.cells=mazeData.getMazeCells();
        setBackground(Color.white);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        int ROWS_TO_PRINT = (mazeData.getRows() * 2) + 1;
        int COLUMNS_TO_PRINT = (mazeData.getColumns() * 2) + 1;
        
        if(cells!=null){
            for(int row =0; row<ROWS_TO_PRINT; row++){
                List<Cell> rowCells = cells.get(row);
                for(int col = 0; col < COLUMNS_TO_PRINT; col++){
                    Cell cell = rowCells.get(col);
                    switch (cell){
                        case WALL -> g.setColor(WALL_COLOR);
                        default -> g.setColor(PATH_COLOR);
                    }
                    g.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                }
            }
        }
     
    }
    
}
