package g54895.atl.project.model;

/**
 * Squares of the board. a square has two attribute, value an integer value
 * contained in the square and hasMerged a boolean value that say if the square
 * has already merged. A square does not know his position.
 *
 * @author Ayoub
 */
public class Square {

    private int value;
    private boolean hasMerged;

    /**
     * Simple constructor of square.
     */
    public Square() {
        this.value = 0;
        hasMerged = false;
    }

    /**
     * Simple getter of value.
     *
     * @return value an integer.
     */
    public int getValue() {
        return value;
    }

    /**
     * Simple getter of hasMerged.
     *
     * @return hasMerged a boolean.
     */
    public boolean getHasMerged() {
        return hasMerged;
    }

    /**
     * Simple setter of value (a method for the tests).
     *
     * @param value an integer
     */
    void setValue(int value) {
        this.value = value;
    }

    /**
     * Method clearValue, set the value of the square at 0.
     */
    public void clearValue() {
        this.value = 0;
    }

    /**
     * Method mergeSquare, if the values of the two squares are equals add the
     * value of the other square to this square,sets hasMerged at true and clear
     * the value of the other square. But if the value of this square is null
     * add the value of the other square to this square and clear the value of
     * the other square.
     *
     * @param square a Square
     */
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

    /**
     * Method isMergable, checks if the square is mergable with another square.
     *
     * @param square a Square
     * @return a boolean true if mergable false otherwise.
     */
    public boolean isMergable(Square square) {
        return this.value == square.value;       
    }

     /**
     * Method isMergableDirection, checks if the square is mergable
     * with another square and if it can actually move.
     *
     * @param square a Square
     * @return a boolean true if mergable false otherwise.
     */
    public boolean isMergableDirection(Square square) {
        if(this.value != 0)
        if (this.value == square.value) {
            return true;
        }else if(square.value == 0)
            return true;
        return false;
    }
    
    /**
     * Method resetMerged , reset the value of hasMerged at null.
     */
    public void resetMerged() {
        this.hasMerged = false;
    }
}
