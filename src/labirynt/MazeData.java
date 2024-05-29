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
    
    public int getNumberOfNodes() {
        return rows*columns;
    }

    public int getStart() {
        return start;
    }
    
    public int getStartX() {
        return start % columns;
    }
    
    public int getStartY() {
        return start / columns;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }
    
    public int getEndX() {
        return end % columns;
    }
    
    public int getEndY() {
        return end / columns;
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
    
    public void setCellType(Cell type, int x, int y){
        mazeCells.get(y).set(x, type);
    }
    
    public Cell getCellType( int x, int y){
        return mazeCells.get(y).get(x);
    }

    public AdjacencyMatrix getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(AdjacencyMatrix adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }
    
    /*public List<List<Node>> getMazeNodes() {
        return mazeNodes;
    }

    public void setMazeNodes(List<List<Node>> mazeNodes) {
        this.mazeNodes = mazeNodes;
    }
    
    public void setNodeType(Cell type, int x, int y){
        mazeNodes.get(y).get(x).setType(type);
    }
    
    public Node node(int id){
        int x = id % columns;
        int y = id / columns;
        return mazeNodes.get(y).get(x);
    }
    
    public int nodeID(int x, int y){
        return y * columns + x;
    }*/
    
    private int rows;
    private int columns;
    private int start;
    private int end;
    
    private List<List<Cell>> mazeCells;
    
    private AdjacencyMatrix adjacencyMatrix;
    
    //private List<List<Node>> mazeNodes;
    
}
