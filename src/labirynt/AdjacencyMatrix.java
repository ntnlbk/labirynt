/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirynt;

import java.util.ArrayList;

/**
 *
 * @author Anton
 */
public class AdjacencyMatrix {
    
    private final int BOTTOM_PATH = 0;
    private final int TOP_PATH = 2;
    private final int LEFT_PATH = 1;
    private final int RIGHT_PATH = 3;
    
    private final boolean paths[] = {false, false, false, false}; 
    
    private final int columns;
    
    private final int rows;
    
    private final ArrayList<boolean[]> matrix = new ArrayList<>();

    public AdjacencyMatrix(int columns, int rows) {
        int size = rows * columns;
        this.rows = rows;
        this.columns = columns;
        for(int i = 0; i < size; i++){
            matrix.add(paths);
        }
    }
    
    public void addPath(int from, Path path){
        int indexToChange;
        switch(path){
            case Path.BOTTOM -> {
                 indexToChange= BOTTOM_PATH;
            }
            case Path.LEFT -> {
                indexToChange= LEFT_PATH;
            }
            case Path.TOP -> {
                indexToChange= TOP_PATH;
            }
            case Path.RIGHT -> {
                indexToChange= RIGHT_PATH;
            }
            default-> {
                indexToChange = 100000;
            }
        }
        changePathToTrue(indexToChange, from);
    }
    
    public int[] getNodesConnectedWitchCurrent(int current){
        boolean[] actualPaths = matrix.get(current);
        ArrayList<Integer> nodes = new ArrayList<>();
        if(actualPaths[BOTTOM_PATH]){
            nodes.add(current + columns);
        }
        if(actualPaths[LEFT_PATH]){
            nodes.add(current - 1);
        } 
        if(actualPaths[TOP_PATH]){
            nodes.add(current - columns);
        } 
        if(actualPaths[RIGHT_PATH]){
            nodes.add(current + 1);
        }
        return nodes.stream().mapToInt(i -> i).toArray();
    }
    
    private void changePathToTrue(int indexToChange, int from){
        boolean newPaths[] = matrix.get(from);
        newPaths[indexToChange] = true;
        matrix.set(from, newPaths);
    }
   
}
