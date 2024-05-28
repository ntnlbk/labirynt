/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Console;

import Console.Console;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anton
 */
public class ConsoleListener extends Thread {
    
    private final Console console;
    
    public ConsoleListener(Console console){
        this.console = console;
    }

    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while (line.equalsIgnoreCase("quit") == false) {
            try {
                line = in.readLine();
                console.setFilePath(line);
                console.notifyObservers();
            } catch (IOException ex) {
            }
            
        }
        try {
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(ConsoleListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
