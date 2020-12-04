package g54895.atl.project.model;

/**
 * Direction represents the 4 direction on the bord directions are Up, Down,
 * Right and Left.
 *
 * @author Ayoub
 */
public enum Direction {
    UP(-1, 0), DOWN(1, 0), RIGHT(0, 1), LEFT(0, -1);
    private int deltaRow;
    private int deltaCol;

    /**
     * Simple Constructor of direction
     *
     * @param deltaRow
     * @param deltaColumn
     */
    private Direction(int deltaRow, int deltaCol) {
        this.deltaRow = deltaRow;
        this.deltaCol = deltaCol;
    }

    /**
     * Simple getter of deltaRow
     *
     * @return deltaRow of the rows
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * Simple getter of deltaColumn
     *
     * @return deltaColumn of the columns
     */
    public int getDeltaCol() {
        return deltaCol;
    }
}
