/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observers;

import java.io.File;
import labirynt.frames.MainFrame;

/**
 *
 * @author Anton
 */
public class ConsoleObserver implements Observer {
    private final MainFrame mainFrame;
    
    public ConsoleObserver(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }
    
    @Override
    public void update(String filePath) {
        mainFrame.showMessage("Wczytano z terminalu: " + filePath + "\n");
        File file = new File(filePath);
        if(file.exists()){
            mainFrame.readFile(file);
        } else{
            mainFrame.showMessage("Plik nie istieje\n");
        }
    }
}
