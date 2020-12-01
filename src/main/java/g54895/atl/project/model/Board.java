/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54895.atl.project.model;

/**
 * Board of the game. Board is made of squares, the squares attribute of the
 * board is made of an 4x4 array of square.
 *
 * @author Ayoub.
 */
public final class Board {

    private Square[][] squares;

    public Board() {
        this.squares = new Square[4][4];
        initBoard();
    }

    /**
     * Method initBoard, inits the board, and appeal the fillRandomSquare
     * method.
     */
    public void initBoard() {
        for (int lg = 0; lg < this.squares.length; lg++) {
            for (int col = 0; col < this.squares[0].length; col++) {
                this.squares[lg][col] = new Square();
            }
        }
        fillRandomSquare();
    }

    /**
     * Method clearBoard, clears the board (Not used yet).
     */
    public void clearBoard() {
        for (int lg = 0; lg < this.squares.length; lg++) {
            for (int col = 0; col < this.squares[0].length; col++) {
                this.squares[lg][col].clearValue();
            }
        }
        fillRandomSquare();
    }

    /**
     * Method fillRandomSquare, fill randomly one of the square of the board
     * with either 2 or 4.
     */
    public void fillRandomSquare() {
        int randLg = pickRandom(4, 0);
        int randCol = pickRandom(4, 0);
        while (this.squares[randLg][randCol].getValue() != 0) {
            randLg = pickRandom(4, 0);
            randCol = pickRandom(4, 0);
        }
        this.squares[randLg][randCol].setValue(randValue());
    }

    /**
     * Method pickRandom, return an integer between the min var and the max var
     * given in parameter.
     *
     * @param max an integer
     * @param min an integer
     * @return a random integer.
     */
    private int pickRandom(int max, int min) {
        return (int) (Math.random() * (max - min));
    }

    /**
     * Method randValue, return randomly either 2 or 4.
     *
     * @return either 2 or 4.
     */
    private int randValue() {
        return Math.random() < 0.9 ? 2 : 4;
    }

    /**
     * Method checkFull, checks if the board of squares is full.
     *
     * @return a boolean, true if full false in the other case.
     */
    public boolean checkFull() {
        for (int lg = 0; lg < this.squares.length; lg++) {
            for (int col = 0; col < this.squares[0].length; col++) {
                if (this.squares[lg][col].getValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method checkMovable, checks if the squares of the board are movable.
     *
     * @return true if movable false otherwise.
     */
    public boolean checkMovable() {
        for (int lg = 0; lg < this.squares.length; lg++) {
            for (int col = 0; col < this.squares[0].length; col++) {
                if (lg + 1 < 4
                        && squares[lg][col].isMergable(squares[lg + 1][col + 0])) {
                    return true;
                } else if (col + 1 < 4
                        && squares[lg][col].isMergable(squares[lg + 0][col + 1])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method checkMovable, checks if the squares of the board are movable.
     *
     * @return true if movable false otherwise.
     */
    public boolean checkMovableDirection(Direction direction) {
        for (int lg = 0; lg < this.squares.length; lg++) {
            for (int col = 0; col < this.squares[0].length; col++) {
                if (direction == Direction.UP) {
                    if (lg - 1 >= 0
                            && squares[lg][col].isMergableDirection(squares[lg - 1][col + 0])) {
                        return true;
                    }
                } else if (direction == Direction.DOWN) {
                    if (lg + 1 < 4
                            && squares[lg][col].isMergableDirection(squares[lg + 1][col + 0])) {
                        return true;
                    }
                } else if (direction == Direction.RIGHT) {
                    if (col + 1 < 4
                            && squares[lg][col].isMergableDirection(squares[lg + 0][col + 1])) {
                        return true;
                    }
                } else if (direction == Direction.LEFT) {
                    if (col - 1 >= 0
                            && squares[lg][col].isMergableDirection(squares[lg + 0][col - 1])) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    /**
     * Method checkWin, checks if one of the squares of the board contains the
     * 2048 number.
     *
     * @return true if contains 2048 false otherwise.
     */
    public boolean checkWin() {
        for (int lg = 0; lg < this.squares.length; lg++) {
            for (int col = 0; col < this.squares[0].length; col++) {
                if (this.squares[lg][col].getValue() == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method resetMergedBool, resets all the hasMerged attribute of the
     * squares.
     */
    public void resetMergedBool() {
        for (int lg = 0; lg < this.squares.length; lg++) {
            for (int col = 0; col < this.squares[0].length; col++) {
                squares[lg][col].resetMerged();
            }
        }
    }

    /**
     * Method move, moves the squares of the board depending on the direction.
     *
     * @param direction a Direction
     */
    public void move(Direction direction) {
        int dRow = direction.getDeltaRow();
        int dCol = direction.getDeltaCol();
        if (checkMovableDirection(direction)) {
            if (direction == Direction.UP) {
                moveUp(dRow, dCol);
            } else if (direction == Direction.DOWN) {
                moveDown(dRow, dCol);
            } else if (direction == Direction.LEFT) {
                moveLeft(dRow, dCol);
            } else if (direction == Direction.RIGHT) {
                moveRight(dRow, dCol);
            }
            if (!this.checkFull()) {
                this.fillRandomSquare();
            }
        } else {
            throw new IllegalArgumentException("Mouvement impossible");//Facultatitf
        }
    }

    /**
     * Method moveUp, moves the squares in the north direction.
     *
     * @param dRow an integer, the deltaRow value of the direction.
     * @param dCol an integer the deltaColumn value of the direction.
     */
    private void moveUp(int dRow, int dCol) {
        for (int lg = 0; lg < this.squares.length; lg++) {
            for (int col = 0; col < this.squares[0].length; col++) {
                if (lg + dRow >= 0) {
                    if ((squares[lg + dRow][col + dCol].getValue() == 0
                            && squares[lg][col].getValue() != 0)) {
                        squares[lg + dRow][col + dCol].mergeSquare(squares[lg][col]);
                        lg = 0;
                    } else if (squares[lg + dRow][col + dCol].getValue()
                            == squares[lg][col].getValue()
                            && !squares[lg + dRow][col + dCol].getHasMerged()
                            && !squares[lg][col].getHasMerged()) {
                        squares[lg + dRow][col + dCol].mergeSquare(squares[lg][col]);
                        lg = 0;
                    }
                }
            }
        }
    }

    /**
     * Method moveDown, moves the squares in the south direction.
     *
     * @param dRow an integer, the deltaRow value of the direction.
     * @param dCol an integer the deltaColumn value of the direction.
     */
    private void moveDown(int dRow, int dCol) {
        for (int lg = this.squares.length - 1; lg >= 0; lg--) {
            for (int col = this.squares[0].length - 1; col >= 0; col--) {
                if (lg + dRow < 4) {
                    if ((squares[lg + dRow][col + dCol].getValue() == 0
                            && squares[lg][col].getValue() != 0)) {
                        squares[lg + dRow][col + dCol].mergeSquare(squares[lg][col]);
                        lg = 3;
                    } else if ((squares[lg + dRow][col + dCol].getValue()
                            == squares[lg][col].getValue())
                            && !squares[lg + dRow][col + dCol].getHasMerged()
                            && !squares[lg][col].getHasMerged()) {
                        squares[lg + dRow][col + dCol].mergeSquare(squares[lg][col]);
                        lg = 3;
                    }
                }
            }
        }
    }

    /**
     * Method moveLeft, moves the squares in the west direction.
     *
     * @param dRow an integer, the deltaRow value of the direction.
     * @param dCol an integer the deltaColumn value of the direction.
     */
    private void moveLeft(int dRow, int dCol) {
        for (int lg = 0; lg < this.squares.length; lg++) {
            for (int col = 0; col < this.squares[0].length; col++) {
                if (col + dCol >= 0) {
                    if ((squares[lg + dRow][col + dCol].getValue() == 0
                            && squares[lg][col].getValue() != 0)) {
                        squares[lg + dRow][col + dCol].mergeSquare(squares[lg][col]);
                        col = 0;
                    } else if (squares[lg + dRow][col + dCol].getValue()
                            == squares[lg][col].getValue()
                            && !squares[lg + dRow][col + dCol].getHasMerged()
                            && !squares[lg][col].getHasMerged()) {
                        squares[lg + dRow][col + dCol].mergeSquare(squares[lg][col]);
                        col = 0;
                    }
                }
            }
        }
    }

    /**
     * Method moveRight, moves the squares in the east direction.
     *
     * @param dRow an integer, the deltaRow value of the direction.
     * @param dCol an integer the deltaColumn value of the direction.
     */
    private void moveRight(int dRow, int dCol) {
        for (int lg = this.squares.length - 1; lg >= 0; lg--) {
            for (int col = this.squares[0].length - 1; col >= 0; col--) {
                if (col + dCol < 4) {
                    if ((squares[lg + dRow][col + dCol].getValue() == 0
                            && squares[lg][col].getValue() != 0)) {
                        squares[lg + dRow][col + dCol].mergeSquare(squares[lg][col]);
                        col = 3;
                    } else if ((squares[lg + dRow][col + dCol].getValue()
                            == squares[lg][col].getValue())
                            && !squares[lg + dRow][col + dCol].getHasMerged()
                            && !squares[lg][col].getHasMerged()) {
                        squares[lg + dRow][col + dCol].mergeSquare(squares[lg][col]);
                        col = 3;
                    }
                }
            }
        }
    }

    /**
     * Simple getter of squares.
     *
     * @param squares an array of Squares.
     */
    Square[][] getSquares() {
        return squares;
    }

    /**
     * Simple setter of squares (Method for the tests).
     *
     * @param squares an array of Squares.
     */
    void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    /**
     * Method getIntBoard, converts the board into a tab of int.
     *
     * @return the string form of the board
     */
    public int[][] getIntBoard() {
        int[][] board = new int[this.squares.length][this.squares[0].length];
        for (int lg = 0; lg < board.length; lg++) {
            for (int col = 0; col < board[0].length; col++) {
                board[lg][col] = squares[lg][col].getValue();
            }
        }
        return board;
    }
}
