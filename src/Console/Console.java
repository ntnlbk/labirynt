/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Console;

import Observers.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anton
 */
public class Console {
    private final List<Observer> observers = new ArrayList<>();
    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
 
    
    
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
 
    
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
 
    
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(filePath);
        }
    }
 
    /*public void setConsoleListener() {
        ConsoleListener consoleListener = new ConsoleListener(this);
        consoleListener.start();
    }*/
}