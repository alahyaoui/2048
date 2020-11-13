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
public class Square {

    private int value;
    private boolean hasMerged;

    public Square() {
        this.value = 0;
        hasMerged = false;
    }

    public int getValue() {
        return value;
    }

    public boolean getHasMerged() {
        return hasMerged;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void clearValue() {
        this.value = 0;
    }

    public void mergeSquare(Square square) {
        if (this.value == square.value) {
            this.value += square.value;
            this.hasMerged = true;
            square.clearValue();
        } else if (this.value == 0) {
            this.value += square.value;
            this.hasMerged = false;
            square.clearValue();
        }
    }
    
    public boolean isMergable(Square square){
        if (this.value == square.value) {
            return true;
        } 
        return false;
    }

    public void resetMerged() {
        this.hasMerged = false;
    }

    @Override
    public String toString() {
        return "[  " + value + "  ]";
    }

}
