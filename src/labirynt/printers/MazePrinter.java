/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirynt.printers;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.List;
import labirynt.MazeData;
import labirynt.Cell;

/**
 *
 * @author Admin
 */
public class MazePrinter extends JPanel{
    
    private final int SQUARE_SIZE = 10;
    
    private final Color WALL_COLOR = Color.BLACK;
    private final Color START_COLOR = Color.ORANGE;
    private final Color END_COLOR = Color.RED;
    private final Color PATH_COLOR = Color.WHITE;
    private final Color PASSAGE_COLOR = Color.GREEN;
    
    private final MazeData mazeData;
    
    public int getSquareSize(){
        return SQUARE_SIZE;
    }
    
    public MazePrinter(MazeData mazeData){
        this.mazeData = mazeData;
        setBackground(Color.white);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        int ROWS_TO_PRINT = (mazeData.getRows() * 2) + 1;
        int COLUMNS_TO_PRINT = (mazeData.getColumns() * 2) + 1;
        List<List<Cell>> cells = mazeData.getMazeCells();
        
        if(cells!=null){
            for(int row =0; row<ROWS_TO_PRINT; row++){
                List<Cell> rowCells = cells.get(row);
                for(int col = 0; col < COLUMNS_TO_PRINT; col++){
                    Cell cell = rowCells.get(col);
                    switch (cell){
                        case WALL -> g.setColor(WALL_COLOR);
                        case PATH -> g.setColor(PASSAGE_COLOR);
                        case START -> g.setColor(START_COLOR);
                        case END -> g.setColor(END_COLOR);
                        default -> g.setColor(PATH_COLOR);
                    }
                    printCell(g, col, row);
                }
            }
        }
     
    }
    
    private void printCell(Graphics g, int col, int row){
        g.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
    }
    
}
