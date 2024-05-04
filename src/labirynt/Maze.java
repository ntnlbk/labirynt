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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Maze { // see java naming conventions https://www.geeksforgeeks.org/java-naming-conventions/
    
    public ArrayList<ArrayList<Character>> mazeFromFile = new ArrayList<>();
    
    public void initializeWindowFromFile(JPanel mainFrame) {
        //JFrame mainFrame = new JFrame("Maze Solver");
        //mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        mainFrame.setLayout(new GridLayout( mazeFromFile.size(),  mazeFromFile.get(0).size()));
        //mainFrame.setSize(1920, 1080); //use preferred size and let layout manager set the size
       // mainFrame.setLocationRelativeTo(null);

        for (int row = 0; row < mazeFromFile.size(); row++) {
            for (int col = 0; col < mazeFromFile.get(row).size(); col++) {
                JLabel label = makeLabel(mazeFromFile.get(row).get(col));
                mainFrame.add(label);
            }
        }
       // mainFrame.pack();
        //mainFrame.setVisible(true);
    }
    public void readFile(){
        
        try(FileInputStream fin=new FileInputStream("src/labirynt/maze150x24.txt"))
        {    
            int i;
            int rows = 0;
             System.out.print(mazeFromFile.size());
            ArrayList<Character> subList = new ArrayList<>() ; 
            while((i=fin.read())!=-1){
                switch(i){
                    case '\n':
                        mazeFromFile.add(subList);
                        subList = new ArrayList<>();
                        break;
                    case ' ':
                        subList.add(' ');
                        break;
                    default :
                        subList.add('#');
                        break;
                }
                
            } 
           
            fin.close();
        }
        catch(IOException ex){
           
            System.out.println(ex.getMessage());
        }
       
    
    }

    private JLabel makeLabel(char c) {

        JLabel label= new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(1, 1));
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