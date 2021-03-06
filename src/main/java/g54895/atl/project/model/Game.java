package g54895.atl.project.model;

import g54895.atl.project.model.Board;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The Game class gathers the elements necessary for the game to present a
 * facade to the view.
 *
 * @author Ayoub
 */
public class Game implements Model {

    private Board board;
    private LevelStatus levelStatus;
    private PropertyChangeSupport pcs;

    /**
     * void construcor of game.
     */
    public Game() {
    }

    /**
     * a startParty method as advertised which initializes the game board and
     * the levelStatus.
     *
     */
    @Override
    public void startParty() {
        this.board = new Board();
        this.levelStatus = LevelStatus.IN_PROGRESS;
        this.pcs = new PropertyChangeSupport(this);
    }

    /**
     * restart the party (Not used yet).
     */
    @Override
    public void restartParty() {
        this.board.clearBoard();
        this.levelStatus = LevelStatus.IN_PROGRESS;
    }

    /**
     * Moves the board and reset the hasMerged value of the each square if the
     * levelStatus is in progess. UpdateStatus at the end.
     *
     * @param direction a Direction
     */
    @Override
    public void move(Direction direction) {//Méthode publique à cause du main Console.
        if (levelStatus == LevelStatus.IN_PROGRESS) {
            board.move(direction);
            board.resetMergedBool();
            updateStatus();
        } else {
            throw new IllegalStateException("La partie n'est pas en cours");
        }
    }

    /**
     * Method updateStatus , updates the status of the game.
     */
    void updateStatus() {
        if (board.checkWin()) {
            this.levelStatus = LevelStatus.WIN;
        } else {
            if (board.checkFull()) {
                if (!board.checkMovable()) {
                    this.levelStatus = LevelStatus.FAIL;
                }
            }
        }
    }

    /**
     * Simple getter of a copy of Board.
     *
     * @return board a Board.
     */
    @Override
    public Board getBoard() {
        return board;
    }

    /**
     * Simple setter of board.
     *
     * @param board a Board
     */
    void setBoard(Board board) {
        this.board = new Board(board);
    }

    /**
     * Simple getter of LevelStatus.
     *
     * @return levelStatus a LevelStatus.
     */
    @Override
    public LevelStatus getLevelStatus() {
        return levelStatus;
    }

    /**
     * Method change , changes the state of the observers
     *
     * @param direction a Direction.
     */
    @Override
    public void change(Direction direction) {
        move(direction);
        pcs.firePropertyChange("Board",
                null, this.board.getIntBoard());
    }

    /**
     * Method change , changes the state of the observers
     */
    @Override
    public void change() {
        pcs.firePropertyChange("Board",
                null, this.board.getIntBoard());
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}
