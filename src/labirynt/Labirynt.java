/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labirynt;

import Console.Console;
import Console.ConsoleListener;
import labirynt.frames.MainFrame;

/**
 *
 * @author Anton
 */
public class Labirynt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        Console console = new Console();
        console.addObserver(mainFrame);
        //console.setConsoleListener();
        ConsoleListener consoleListener = new ConsoleListener(console);
        consoleListener.start();
    }
    
}
