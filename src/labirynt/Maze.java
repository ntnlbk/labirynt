/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirynt;

/**
 *
 * @author Anton
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Maze { // see java naming conventions https://www.geeksforgeeks.org/java-naming-conventions/

    static char[][] puzzle = { { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
            { '#', ' ', ' ', ' ', '#', ' ', '#', '#', '#', '#', ' ', 'X', '#' },
            { '#', '#', ' ', '#', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#' },
            { '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#' },
            { '#', ' ', '#', ' ', ' ', '#', '#', '#', '#', ' ', '#', '#', '#' },
            { '#', '#', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
            { '#', ' ', ' ', ' ', ' ', '#', '#', ' ', ' ', '#', '#', '#', '#' },
            { '#', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', '#' },
            { '#', ' ', '#', ' ', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', '#' },
            { '#', ' ', '#', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#' },
            { '#', ' ', ' ', ' ', ' ', '#', '#', ' ', ' ', ' ', '#', '#', '#' },
            { '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', ' ', ' ', '#', '#' },
            { '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#' },
            { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' }, };

    

    public void initializeWindow(JPanel mainFrame) {
        //JFrame mainFrame = new JFrame("Maze Solver");
        //mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(puzzle.length, puzzle[0].length));
        //mainFrame.setSize(1920, 1080); //use preferred size and let layout manager set the size
       // mainFrame.setLocationRelativeTo(null);

        for (int row = 0; row < puzzle.length; row++) {
            for (int col = 0; col < puzzle[0].length; col++) {
                JLabel label = makeLabel(puzzle[row][col]);
                mainFrame.add(label);
            }
        }
       // mainFrame.pack();
        //mainFrame.setVisible(true);
    }

    private JLabel makeLabel(char c) {

        JLabel label= new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(40, 40));
        switch(c) {
            case '#':
                label.setBackground(Color.BLUE);
                break;
            default:
                label.setBackground(Color.WHITE);
                break;

        }
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        return label;
    }
}