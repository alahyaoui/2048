package g54895.atl.project.model;

import java.beans.PropertyChangeListener;

/**
 * Interface model of the MVC structure.
 *
 * @author Ayoub.
 */
public interface Model {

    /**
     * a startParty method as advertised which initializes the game board and
     * the levelStatus.
     *
     */
    public void startParty();

    /**
     * restart the party (Not used yet).
     */
    public void restartParty();

    /**
     * Moves the board and reset the hasMerged value of the each square if the
     * levelStatus is in progess. UpdateStatus at the end.
     *
     * @param direction a Direction
     */
    public void move(Direction direction);

    /**
     * Simple getter of Board
     *
     * @return board a Board.
     */
    public LevelStatus getLevelStatus();

    /**
     * Simple getter of LevelStatus.
     *
     * @return levelStatus a LevelStatus.
     */
    public Board getBoard();
    
    /**
     * Method change , changes the state of the observers
     *
     * @param direction a Direction
     */
    public void change(Direction direction);

    /**
     * Method change , changes the state of the observers
     */
    public void change();

    public void addPropertyChangeListener(PropertyChangeListener listener);

}
