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
    
    private int rows;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<List<Cell>> getMazeCells() {
        return mazeCells;
    }

    public void setMazeCells(List<List<Cell>> mazeCells) {
        this.mazeCells = mazeCells;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }
    private int columns;
    private int start;
    private int end;
    
    //dla rysowania
    private List<List<Cell>> mazeCells;
    //dla rozwiązania
    private int[][] adjacencyMatrix;
    
}
