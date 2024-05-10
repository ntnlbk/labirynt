/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirynt.printers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import labirynt.Cell;

/**
 *
 * @author Anton
 */
public class MazePrinter {
    
    
    private final List<List<Cell>> cells;
    
    public MazePrinter(List<List<Cell>> cells){
        this.cells=cells;
    }
    
    private JLabel makeLabel(Cell c) {

        JLabel label= new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(1, 1));
        switch(c) {
            case Cell.WALL -> label.setBackground(Color.BLUE);
            default -> label.setBackground(Color.WHITE);

        }
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        return label;
    }
    
    public void print(JPanel mainFrame) {

        mainFrame.setLayout(new GridLayout( cells.size(),  cells.get(0).size()));
      
        for (int row = 0; row < cells.size(); row++) {
            for (int col = 0; col < cells.get(row).size(); col++) {
                JLabel label = makeLabel(cells.get(row).get(col));
                mainFrame.add(label);
            }
        }
        mainFrame.updateUI();
    }
    
}
