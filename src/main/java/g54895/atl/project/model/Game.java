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
public class Game implements Model {

    private Board board;
    private LevelStatus levelStatus;

    public Game() {
    }

    @Override
    public void startParty() {
        this.board = new Board();
        this.levelStatus = LevelStatus.IN_PROGRESS;
    }

    /**
     * restart the party
     */
    @Override
    public void restartParty() {
        //board.clearBoard();
        this.startParty();
    }

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

    @Override
    public void updateStatus() {
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

    public Board getBoard() {
        return board;
    }

    public LevelStatus getLevelStatus() {
        return levelStatus;
    }
}
