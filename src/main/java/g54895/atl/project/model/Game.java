/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54895.atl.project.model;

/**
 * The Game class gathers the elements necessary for the game to present a
 * facade to the view.
 *
 * @author Ayoub
 */
public class Game implements Model {

    private Board board;
    private LevelStatus levelStatus;

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
    }

    /**
     * restart the party (Not used yet).
     */
    @Override
    public void restartParty() {
        //board.clearBoard();
        this.startParty();
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
}
