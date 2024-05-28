/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirynt;

import java.util.List;

/**
 *
 * @author Admin
 */
public class Path {
    private List<Integer> path;
    private boolean visible;
    private MazeData mazeData;
    
    public Path(List<Integer> path, MazeData mazeData){
        this.path = path;
        this.visible = false;
        this.mazeData = mazeData;
    }
    
    public boolean isVisible(){
        return visible;
    }
    
    public void show(){
        colorPath(Cell.PATH);
        visible = true;
    }
    
    public void hide(){
        colorPath(Cell.SPACE);
        visible = false;
    }

    private void colorPath(Cell type){
        List<List<Cell>> cells = mazeData.getMazeCells();
        int columns = mazeData.getColumns();
        int currX, currY;
        int nextX, nextY;
        for(int i=0; i < path.size()-1; i++){
            currX = cellNumber(path.get(i) % columns);
            currY = cellNumber(path.get(i) / columns);
            nextX = cellNumber(path.get(i+1) % columns);
            nextY = cellNumber(path.get(i+1) / columns);
            if ( currX == nextX){
                int min = Math.min(currY, nextY);
                int max = Math.max(currY, nextY);
                for (int j = min; j <= max; j++){
                    if(cells.get(j).get(currX) != Cell.START && cells.get(j).get(currX) != Cell.END)
                    cells.get(j).set(currX, type);
                }
            } else{
                int min = Math.min(currX, nextX);
                int max = Math.max(currX, nextX);
                for (int j = min; j <= max; j++){
                    if(cells.get(currY).get(j) != Cell.START && cells.get(currY).get(j) != Cell.END)
                    cells.get(currY).set(j, type);
                }
            }
        }
    }
    
    private int cellNumber(int node){
        return node * 2 + 1;
    }
}
