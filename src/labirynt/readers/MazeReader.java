/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirynt.readers;

import java.io.File;
import labirynt.MazeData;
import labirynt.frames.MainFrame;

/**
 *
 * @author Anton
 */
public class MazeReader {
    
    private final File file;
    private final MazeData mazeData;
    private String message;
    
    public MazeReader(File file, MazeData mazeData, MainFrame mainFrame){
        this.file = file;
        this.mazeData = mazeData;
    }
    
    public String getMessage(){
        return message;
    }
    
    public void readFile(){
        parseFile();
    }
    
    private void parseFile() {
        String fileName = file.getName();
        switch (getFileExtension(fileName)){
            case "txt" -> {
                message = "Plik tekstowy <br>";
                TxtReader reader = new TxtReader(file.getAbsolutePath());
                reader.readFromFile(mazeData);
                
            }
            
            case "bin" -> {
                message = "Plik binarny <br>";
                BinReader reader = new BinReader(file.getAbsolutePath());
                reader.readFromFile(mazeData);
            }
            default ->{
                message = "Plik ma format nieobsługiwany: " + getFileExtension(fileName) + "<br>";
            }
        }
        
    }
    
    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
    
    
    
}
