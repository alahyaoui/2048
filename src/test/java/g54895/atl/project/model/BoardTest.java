/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54895.atl.project.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ayoub
 */
public class BoardTest {

    public BoardTest() {
    }

    @BeforeEach
    public void setUp() {
    }

    /**
     * Test of initBoard method, of class Board.
     */
    @Test
    public void testInitBoard() {
        System.out.println("initBoard");
        Board instanceBoard = new Board();
        instanceBoard.initBoard();
        int instanceNbOfNullValue = 0;
        int expResultNbOfNullValue = 15;

        for (Square[] squares : instanceBoard.getSquares()) {
            for (Square square : squares) {
                if (square.getValue() == 0) {
                    instanceNbOfNullValue++;
                }
            }
        }
        assertEquals(expResultNbOfNullValue, instanceNbOfNullValue);
    }

    /**
     * Test of clearBoard method, of class Board.
     */
    @Test
    public void testClearBoard() {
        System.out.println("clearBoard");
        Board instanceBoard = new Board();
        instanceBoard.clearBoard();
        int instanceNbOfNullValue = 0;
        int expResultNbOfNullValue = 15;

        for (Square[] squares : instanceBoard.getSquares()) {
            for (Square square : squares) {
                if (square.getValue() == 0) {
                    instanceNbOfNullValue++;
                }
            }
        }
        assertEquals(expResultNbOfNullValue, instanceNbOfNullValue);
    }

    /**
     * Test of checkFull method, of class Board.
     */
    @Test
    public void testCheckFull() {
        System.out.println("checkFull");
        Board instanceBoard = new Board();

        boolean expResult = false;
        boolean result = instanceBoard.checkFull();

        Square[][] squares = {{new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};

        int nb = 2;

        for (int lg = 0; lg < squares.length; lg++) {
            for (int col = 0; col < squares[0].length; col++) {
                nb *= 2;
                squares[lg][col].setValue(nb);
            }
        }

        instanceBoard.setSquares(squares);

        boolean expResult2 = true;
        boolean result2 = instanceBoard.checkFull();

        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMoveGeneralUp() {
        System.out.println("Test Move General Up");
        Direction direction = Direction.UP;
        Board instanceBoard = new Board();

        Square[][] squares = {{new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};

        squares[0][0].setValue(2);
        squares[2][2].setValue(2);
        instanceBoard.setSquares(squares);

        String[][] board = instanceBoard.getStrBoard();;
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }
        System.out.println("");

        instanceBoard.move(direction);

        int expSquare0Result = 2;
        int square0Result = squares[0][0].getValue();

        int expSquare1Result = 2;
        int square1Result = squares[0][2].getValue();

        board = instanceBoard.getStrBoard();
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }

        assertEquals(expSquare0Result, square0Result);
        assertEquals(expSquare1Result, square1Result);
    }
    
    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMoveGeneralLeft() {
        System.out.println("Test Move General Left");
        Direction direction = Direction.LEFT;
        Board instanceBoard = new Board();

        Square[][] squares = {{new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};

        squares[0][0].setValue(2);
        squares[2][2].setValue(2);
        instanceBoard.setSquares(squares);

        String[][] board = instanceBoard.getStrBoard();;
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }
        System.out.println("");

        instanceBoard.move(direction);

        int expSquare0Result = 2;
        int square0Result = squares[0][0].getValue();

        int expSquare1Result = 2;
        int square1Result = squares[2][0].getValue();

        board = instanceBoard.getStrBoard();
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }

        assertEquals(expSquare0Result, square0Result);
        assertEquals(expSquare1Result, square1Result);
    }
    
    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMoveGeneralDown() {
        System.out.println("Test Move General Down");
        Direction direction = Direction.DOWN;
        Board instanceBoard = new Board();

        Square[][] squares = {{new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};

        squares[0][0].setValue(2);
        squares[2][2].setValue(2);
        instanceBoard.setSquares(squares);

        String[][] board = instanceBoard.getStrBoard();;
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }
        System.out.println("");

        instanceBoard.move(direction);

        int expSquare0Result = 2;
        int square0Result = squares[3][0].getValue();

        int expSquare1Result = 2;
        int square1Result = squares[3][2].getValue();

        board = instanceBoard.getStrBoard();
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }

        assertEquals(expSquare0Result, square0Result);
        assertEquals(expSquare1Result, square1Result);
    }
    
    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMoveGeneralRight() {
        System.out.println("Test Move General 4");
        Direction direction = Direction.RIGHT;
        Board instanceBoard = new Board();

        Square[][] squares = {{new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};

        squares[0][0].setValue(2);
        squares[2][2].setValue(2);
        instanceBoard.setSquares(squares);

        String[][] board = instanceBoard.getStrBoard();;
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }
        System.out.println("");

        instanceBoard.move(direction);

        int expSquare0Result = 2;
        int square0Result = squares[0][3].getValue();

        int expSquare1Result = 2;
        int square1Result = squares[2][3].getValue();

        board = instanceBoard.getStrBoard();
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }

        assertEquals(expSquare0Result, square0Result);
        assertEquals(expSquare1Result, square1Result);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMoveUp1() {
        System.out.println("Test Move UP 1 and merge the 4 not null square");
        Direction direction = Direction.UP;
        Board instanceBoard = new Board();
        Square[][] squares = {{new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};
        squares[0][0].setValue(4);
        squares[1][0].setValue(4);
        squares[2][0].setValue(2);
        squares[3][0].setValue(2);
        instanceBoard.setSquares(squares);

        String[][] board = instanceBoard.getStrBoard();;
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }
        System.out.println("");

        instanceBoard.move(direction);

        int expSquare0Result = 8;
        int square0Result = squares[0][0].getValue();

        int expSquare1Result = 4;
        int square1Result = squares[1][0].getValue();

        int expSquare2Result = 0;
        int square2Result = squares[2][0].getValue();

        int expSquare3Result = 0;
        int square3Result = squares[3][0].getValue();

        board = instanceBoard.getStrBoard();
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }

        assertEquals(expSquare0Result, square0Result);
        assertEquals(expSquare1Result, square1Result);
        assertEquals(expSquare2Result, square2Result);
        assertEquals(expSquare3Result, square3Result);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMoveUp2() {
        System.out.println("Test Move UP 2 and merge the 4 not null square");
        Direction direction = Direction.UP;
        Board instanceBoard = new Board();
        Square[][] squares = {{new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};
        squares[0][1].setValue(4);
        squares[1][1].setValue(4);
        squares[2][1].setValue(2);
        squares[3][1].setValue(2);
        instanceBoard.setSquares(squares);

        String[][] board = instanceBoard.getStrBoard();;
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }
        System.out.println("");

        instanceBoard.move(direction);

        int expSquare0Result = 8;
        int square0Result = squares[0][1].getValue();

        int expSquare1Result = 4;
        int square1Result = squares[1][1].getValue();

        int expSquare2Result = 0;
        int square2Result = squares[2][1].getValue();

        int expSquare3Result = 0;
        int square3Result = squares[3][1].getValue();

        board = instanceBoard.getStrBoard();
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }

        assertEquals(expSquare0Result, square0Result);
        assertEquals(expSquare1Result, square1Result);
        assertEquals(expSquare2Result, square2Result);
        assertEquals(expSquare3Result, square3Result);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMoveDown1() {
        System.out.println("Test Move Down 1 and merge the 4 not null square");
        Direction direction = Direction.DOWN;
        Board instanceBoard = new Board();
        Square[][] squares = {{new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};
        squares[0][0].setValue(2);
        squares[1][0].setValue(2);
        squares[2][0].setValue(4);
        squares[3][0].setValue(4);
        instanceBoard.setSquares(squares);

        String[][] board = instanceBoard.getStrBoard();;
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }
        System.out.println("");

        instanceBoard.move(direction);

        int expSquare0Result = 0;
        int square0Result = squares[0][0].getValue();

        int expSquare1Result = 0;
        int square1Result = squares[1][0].getValue();

        int expSquare2Result = 4;
        int square2Result = squares[2][0].getValue();

        int expSquare3Result = 8;
        int square3Result = squares[3][0].getValue();

        board = instanceBoard.getStrBoard();
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }

        assertEquals(expSquare0Result, square0Result);
        assertEquals(expSquare1Result, square1Result);
        assertEquals(expSquare2Result, square2Result);
        assertEquals(expSquare3Result, square3Result);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMoveDown2() {
        System.out.println("Test Move Down 2 and merge the 4 not null square");
        Direction direction = Direction.DOWN;
        Board instanceBoard = new Board();
        Square[][] squares = {{new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};
        squares[0][1].setValue(2);
        squares[1][1].setValue(2);
        squares[2][1].setValue(4);
        squares[3][1].setValue(4);
        instanceBoard.setSquares(squares);

        String[][] board = instanceBoard.getStrBoard();
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }
        System.out.println("");

        instanceBoard.move(direction);

        int expSquare0Result = 0;
        int square0Result = squares[0][1].getValue();

        int expSquare1Result = 0;
        int square1Result = squares[1][1].getValue();

        int expSquare2Result = 4;
        int square2Result = squares[2][1].getValue();

        int expSquare3Result = 8;
        int square3Result = squares[3][1].getValue();

        board = instanceBoard.getStrBoard();
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }

        assertEquals(expSquare0Result, square0Result);
        assertEquals(expSquare1Result, square1Result);
        assertEquals(expSquare2Result, square2Result);
        assertEquals(expSquare3Result, square3Result);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMoveLeft1() {
        System.out.println("Test Move Left 1 and merge the 4 not null square");
        Direction direction = Direction.LEFT;
        Board instanceBoard = new Board();
        Square[][] squares = {{new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};
        squares[0][0].setValue(4);
        squares[0][1].setValue(4);
        squares[0][2].setValue(2);
        squares[0][3].setValue(2);
        instanceBoard.setSquares(squares);

        String[][] board = instanceBoard.getStrBoard();;
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }
        System.out.println("");

        instanceBoard.move(direction);

        int expSquare0Result = 8;
        int square0Result = squares[0][0].getValue();

        int expSquare1Result = 4;
        int square1Result = squares[0][1].getValue();

        int expSquare2Result = 0;
        int square2Result = squares[0][2].getValue();

        int expSquare3Result = 0;
        int square3Result = squares[0][3].getValue();

        board = instanceBoard.getStrBoard();
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }

        assertEquals(expSquare0Result, square0Result);
        assertEquals(expSquare1Result, square1Result);
        assertEquals(expSquare2Result, square2Result);
        assertEquals(expSquare3Result, square3Result);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMoveLeft2() {
        System.out.println("Test Move Left 2 and merge the 4 not null square");
        Direction direction = Direction.LEFT;
        Board instanceBoard = new Board();
        Square[][] squares = {{new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};
        squares[1][0].setValue(4);
        squares[1][1].setValue(4);
        squares[1][2].setValue(2);
        squares[1][3].setValue(2);
        instanceBoard.setSquares(squares);

        String[][] board = instanceBoard.getStrBoard();;
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }
        System.out.println("");

        instanceBoard.move(direction);

        int expSquare0Result = 8;
        int square0Result = squares[1][0].getValue();

        int expSquare1Result = 4;
        int square1Result = squares[1][1].getValue();

        int expSquare2Result = 0;
        int square2Result = squares[1][2].getValue();

        int expSquare3Result = 0;
        int square3Result = squares[1][3].getValue();

        board = instanceBoard.getStrBoard();
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }

        assertEquals(expSquare0Result, square0Result);
        assertEquals(expSquare1Result, square1Result);
        assertEquals(expSquare2Result, square2Result);
        assertEquals(expSquare3Result, square3Result);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMoveRight1() {
        System.out.println("Test Move Right 1 and merge the 4 not null square");
        Direction direction = Direction.RIGHT;
        Board instanceBoard = new Board();
        Square[][] squares = {{new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};
        squares[0][0].setValue(2);
        squares[0][1].setValue(2);
        squares[0][2].setValue(4);
        squares[0][3].setValue(4);
        instanceBoard.setSquares(squares);

        String[][] board = instanceBoard.getStrBoard();;
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }
        System.out.println("");

        instanceBoard.move(direction);

        int expSquare0Result = 0;
        int square0Result = squares[0][0].getValue();

        int expSquare1Result = 0;
        int square1Result = squares[0][1].getValue();

        int expSquare2Result = 4;
        int square2Result = squares[0][2].getValue();

        int expSquare3Result = 8;
        int square3Result = squares[0][3].getValue();

        board = instanceBoard.getStrBoard();
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }

        assertEquals(expSquare0Result, square0Result);
        assertEquals(expSquare1Result, square1Result);
        assertEquals(expSquare2Result, square2Result);
        assertEquals(expSquare3Result, square3Result);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMoveRight2() {
        System.out.println("Test Move Right 2 and merge the 4 not null square");
        Direction direction = Direction.RIGHT;
        Board instanceBoard = new Board();
        Square[][] squares = {{new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};
        squares[1][0].setValue(2);
        squares[1][1].setValue(2);
        squares[1][2].setValue(4);
        squares[1][3].setValue(4);
        instanceBoard.setSquares(squares);

        String[][] board = instanceBoard.getStrBoard();;
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }
        System.out.println("");

        instanceBoard.move(direction);

        int expSquare0Result = 0;
        int square0Result = squares[1][0].getValue();

        int expSquare1Result = 0;
        int square1Result = squares[1][1].getValue();

        int expSquare2Result = 4;
        int square2Result = squares[1][2].getValue();

        int expSquare3Result = 8;
        int square3Result = squares[1][3].getValue();

        board = instanceBoard.getStrBoard();
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }

        assertEquals(expSquare0Result, square0Result);
        assertEquals(expSquare1Result, square1Result);
        assertEquals(expSquare2Result, square2Result);
        assertEquals(expSquare3Result, square3Result);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testDontMoveLeft1() {
        System.out.println("Test Dont Move Left 1 and don't merge any square");
        Direction direction = Direction.LEFT;
        Board instanceBoard = new Board();
        Square[][] squares = {{new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};
        squares[0][0].setValue(4);
        squares[0][1].setValue(2);
        squares[0][2].setValue(4);
        squares[0][3].setValue(2);
        instanceBoard.setSquares(squares);

        String[][] board = instanceBoard.getStrBoard();;
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }
        System.out.println("");

        instanceBoard.move(direction);

        int expSquare0Result = 4;
        int square0Result = squares[0][0].getValue();

        int expSquare1Result = 2;
        int square1Result = squares[0][1].getValue();

        int expSquare2Result = 4;
        int square2Result = squares[0][2].getValue();

        int expSquare3Result = 2;
        int square3Result = squares[0][3].getValue();

        board = instanceBoard.getStrBoard();
        for (String[] strBoard : board) {
            for (String str : strBoard) {
                System.out.print(str);
            }
            System.out.println("");
        }

        assertEquals(expSquare0Result, square0Result);
        assertEquals(expSquare1Result, square1Result);
        assertEquals(expSquare2Result, square2Result);
        assertEquals(expSquare3Result, square3Result);
    }

}
