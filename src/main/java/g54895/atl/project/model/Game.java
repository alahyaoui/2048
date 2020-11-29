/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54895.atl.project.model;

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
    public void move(Direction direction) {
        if (levelStatus == LevelStatus.IN_PROGRESS) {
            board.move(direction);
            board.resetMergedBool();
        } else {
            throw new IllegalStateException("La partie n'est pas en cours");
        }
        updateStatus();
    }

    /**
     * Method updateStatus , updates the status of the game.
     */
    private void updateStatus() {
        if (board.checkWin()) {
            this.levelStatus = LevelStatus.WIN;
        } else {
            if (board.checkFull()) {
                if (!board.checkMovable()) {
                    this.levelStatus = LevelStatus.FAIL;
                }
            } else {
                board.fillRandomSquare();
            }
        }
    }

    /**
     * Method checkeStatus , check if you can still move if not
     */
    @Override
    public void checkStatus() {
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
     * Simple getter of Board
     *
     * @return board a Board.
     */
    @Override
    public Board getBoard() {
        return board;
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
     * @param direction
     */
    @Override
    public void change(Direction direction) {
        int[][] oldBoard = new int[4][4];
        for (int i = 0; i < this.board.getIntBoard().length; i++) {
            for (int j = 0; j < this.board.getIntBoard()[0].length; j++) {
                oldBoard[i][j] = this.board.getIntBoard()[i][j];
            }
        }

        move(direction);

        for (int i = 0; i < this.board.getIntBoard().length; i++) {
            for (int j = 0; j < this.board.getIntBoard()[0].length; j++) {
                pcs.firePropertyChange("Board[" + i + "," + j + "]", oldBoard[i][j], this.board.getIntBoard()[i][j]);
            }
        }
    }

    /**
     * Method change , changes the state of the observers
     */
    public void change() {
        int[][] oldBoard = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                oldBoard[i][j] = 1;
            }
        }

        for (int i = 0; i < this.board.getIntBoard().length; i++) {
            for (int j = 0; j < this.board.getIntBoard()[0].length; j++) {
                pcs.firePropertyChange("Board[" + i + "," + j + "]", oldBoard[i][j], this.board.getIntBoard()[i][j]);
            }
        }
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}
