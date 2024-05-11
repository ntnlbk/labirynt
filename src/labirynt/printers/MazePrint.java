/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirynt.printers;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import labirynt.Cell;

/**
 *
 * @author Admin
 */
public class MazePrint extends JPanel{
    
    private String filePath;
    private final List<List<Cell>> cells;
    
    public MazePrint(List<List<Cell>> cells){
        this.cells=cells;
        setBackground(Color.white);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        int squareSize = 7;
        super.paintComponent(g);
        
        if(cells!=null){
            for(int row =0; row<cells.size(); row++){
                List<Cell> rowCells = cells.get(row);
                for(int col = 0; col < rowCells.size(); col++){
                    Cell cell = rowCells.get(col);
                    switch (cell){
                        case WALL:
                            g.setColor(Color.black);
                            break;
                        default:
                            g.setColor(Color.white);
                            break;
                    }
                    g.fillRect(col * squareSize, row * squareSize, squareSize, squareSize);
                }
            }
        }
        
        /*try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            int row = 0;
            String line;
            while ((line = br.readLine()) != null) {
                for (int col = 0; col<line.length(); col++){
                    if (line.charAt(col) == 'X'){
                        g.setColor(Color.black);
                    } else {
                        g.setColor(Color.white);
                    }
                    g.fillRect(col * squareSize, row * squareSize, squareSize, squareSize);
                    //System.out.println("Kolumna: "+ col +" Wiersz: " + row);
                }
                row++;
            }
            
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        */
    }
    
    /*public Dimension getPrefferedSize() {
        return new Dimension(200,200);
    }*/
}
