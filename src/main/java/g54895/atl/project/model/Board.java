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
public final class Board {

    private Square[][] squares;

    public Board() {
        this.squares = new Square[4][4];
        initBoard();
    }

    public void initBoard() {
        for (int lg = 0; lg < this.squares.length; lg++) {
            for (int col = 0; col < this.squares[0].length; col++) {
                this.squares[lg][col] = new Square();
            }
        }
        fillRandomSquare();
    }

    public void clearBoard() {
        for (int lg = 0; lg < this.squares.length; lg++) {
            for (int col = 0; col < this.squares[0].length; col++) {
                this.squares[lg][col].clearValue();
            }
        }
        fillRandomSquare();
    }

    public void fillRandomSquare() {
        int randLg = pickRandom(4, 0);
        int randCol = pickRandom(4, 0);
        while (this.squares[randLg][randCol].getValue() != 0) {//Attention a la boucle infinie si toute les cases sont remplies !!!!
            randLg = pickRandom(4, 0);
            randCol = pickRandom(4, 0);
        }
        this.squares[randLg][randCol].setValue(randValue());
    }

    private int pickRandom(int max, int min) {
        return (int) (Math.random() * (max - min));
    }

    private int randValue() {
        return Math.random() < 0.9 ? 2 : 4;
    }

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
    
     public boolean checkMovable() {    
        for (int lg = 0; lg < this.squares.length; lg++) {
            for (int col = 0; col < this.squares[0].length; col++) {
                if (lg + 1 < 4 && squares[lg][col].isMergable(squares[lg + 1][col + 0])) {
                    return true;
                }else if(col + 1 < 4 && squares[lg][col].isMergable(squares[lg + 0][col + 1])){
                    return true;
                }
            }
        }
        return false;
    }

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

    public void resetMergedBool() {
        for (int lg = 0; lg < this.squares.length; lg++) {
            for (int col = 0; col < this.squares[0].length; col++) {
                squares[lg][col].resetMerged();
            }
        }
    }

    public void move(Direction direction) {
        int dRow = direction.getDeltaRow();
        int dCol = direction.getDeltaCol();
        if (direction == Direction.UP) {
            moveUp(dRow, dCol);
        } else if (direction == Direction.DOWN) {
            moveDown(dRow, dCol);
        } else if (direction == Direction.LEFT) {
            moveLeft(dRow, dCol);
        } else if (direction == Direction.RIGHT) {
            moveRight(dRow, dCol);
        }
    }

    private void moveUp(int dRow, int dCol) {
        for (int lg = 0; lg < this.squares.length; lg++) {
            for (int col = 0; col < this.squares[0].length; col++) {
                if (lg + dRow >= 0) {
                    if ((squares[lg + dRow][col + dCol].getValue() == 0
                            && squares[lg][col].getValue() != 0)) {
                        squares[lg + dRow][col + dCol].mergeSquare(squares[lg][col]);
                        lg = 0;
                    } else if (squares[lg + dRow][col + dCol].getValue() == squares[lg][col].getValue()
                            && !squares[lg + dRow][col + dCol].getHasMerged() && !squares[lg ][col].getHasMerged()) {
                        squares[lg + dRow][col + dCol].mergeSquare(squares[lg][col]);
                        lg = 0;
                    }
                }
            }
        }
    }

    private void moveDown(int dRow, int dCol) {
        for (int lg = this.squares.length - 1; lg >= 0; lg--) {
            for (int col = this.squares[0].length - 1; col >= 0; col--) {
                if (lg + dRow < 4) {
                    if ((squares[lg + dRow][col + dCol].getValue() == 0
                            && squares[lg][col].getValue() != 0)) {
                        squares[lg + dRow][col + dCol].mergeSquare(squares[lg][col]);
                        lg = 3;
                    } else if ((squares[lg + dRow][col + dCol].getValue() == squares[lg][col].getValue())
                            && !squares[lg + dRow][col + dCol].getHasMerged() && !squares[lg ][col].getHasMerged()) {
                        squares[lg + dRow][col + dCol].mergeSquare(squares[lg][col]);
                        lg = 3;
                    }
                }
            }
        }
    }

    private void moveLeft(int dRow, int dCol) {
        for (int lg = 0; lg < this.squares.length; lg++) {
            for (int col = 0; col < this.squares[0].length; col++) {
                if (col + dCol >= 0) {
                    if ((squares[lg + dRow][col + dCol].getValue() == 0
                            && squares[lg][col].getValue() != 0)) {
                        squares[lg + dRow][col + dCol].mergeSquare(squares[lg][col]);
                        col = 0;
                    } else if (squares[lg + dRow][col + dCol].getValue() == squares[lg][col].getValue()
                            && !squares[lg + dRow][col + dCol].getHasMerged() && !squares[lg ][col].getHasMerged()) {
                        squares[lg + dRow][col + dCol].mergeSquare(squares[lg][col]);
                        col = 0;
                    }
                }
            }
        }
    }

    private void moveRight(int dRow, int dCol) {
        for (int lg = this.squares.length - 1; lg >= 0; lg--) {
            for (int col = this.squares[0].length - 1; col >= 0; col--) {
                if (col + dCol < 4) {
                    if ((squares[lg + dRow][col + dCol].getValue() == 0
                            && squares[lg][col].getValue() != 0)) {
                        squares[lg + dRow][col + dCol].mergeSquare(squares[lg][col]);
                        col = 3;
                    } else if ((squares[lg + dRow][col + dCol].getValue() == squares[lg][col].getValue())
                            && !squares[lg + dRow][col + dCol].getHasMerged() && !squares[lg ][col].getHasMerged()) {
                        squares[lg + dRow][col + dCol].mergeSquare(squares[lg][col]);
                        col = 3;
                    }
                }
            }
        }
    }

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    public String[][] getBoard() {
        String[][] board = new String[this.squares.length][this.squares[0].length];
        for (int lg = 0; lg < board.length; lg++) {
            for (int col = 0; col < board[0].length; col++) {
                board[lg][col] = squares[lg][col].toString();
            }
        }
        return board;
    }

}
