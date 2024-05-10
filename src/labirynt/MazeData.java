/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirynt;

import java.util.List;

/**
 *
 * @author Anton
 */
public class MazeData {
    
    public int rows;
    public int columns;
    public int start;
    public int end;
    //dla rysowania
    public List<List<Cell>> mazeCells;
    //dla rozwiązania
    public int[][] adjacencyMatrix;
    
}
