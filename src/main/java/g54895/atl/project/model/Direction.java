/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54895.atl.project.model;

/**
 *
 * @author Ayoub
 */
public enum Direction {
    UP(-1, 0),DOWN(1, 0),RIGHT(0, 1),LEFT(0, -1);
    private int deltaRow;
    private int deltaCol;

    private Direction(int deltaRow, int deltaCol) {
        this.deltaRow = deltaRow;
        this.deltaCol = deltaCol;
    }

    public int getDeltaRow() {
        return deltaRow;
    }

    public int getDeltaCol() {
        return deltaCol;
    }   
}
