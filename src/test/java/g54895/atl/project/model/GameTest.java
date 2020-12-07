package g54895.atl.project.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ayoub
 */
public class GameTest {

    Game instanceGame = new Game();

    @BeforeEach
    public void setUp() {
        //instanceGame = new Game();
        instanceGame.startParty();
    }

    /**
     * Test of startParty method, of class Game.
     */
    @Test
    public void testStartParty() {
        System.out.println("startParty");
        instanceGame.startParty();

        assertNotNull(instanceGame.getBoard());
        assertEquals(instanceGame.getLevelStatus(), LevelStatus.IN_PROGRESS);
    }

    /**
     * Test of restartParty method, of class Game.
     */
    @Test
    public void testRestartParty() {
        System.out.println("restartParty");
        instanceGame.startParty();
        Board instanceBoard = new Board();

        Square[][] squares
                = {{new Square(), new Square(), new Square(), new Square()},
                {new Square(), new Square(), new Square(), new Square()},
                {new Square(), new Square(), new Square(), new Square()},
                {new Square(), new Square(), new Square(), new Square()}};

        squares[0][0].setValue(2048);
        instanceBoard.setSquares(squares);
        instanceGame.setBoard(instanceBoard);
        
        instanceGame.updateStatus();
        
        LevelStatus expLevelStatus = LevelStatus.WIN;
        LevelStatus resLevelStatus = instanceGame.getLevelStatus();
        
        assertEquals(expLevelStatus, resLevelStatus);
        
        instanceGame.restartParty();
        
        expLevelStatus = LevelStatus.IN_PROGRESS;
        resLevelStatus = instanceGame.getLevelStatus();

        assertNotNull(instanceGame.getBoard());
        assertEquals(expLevelStatus, resLevelStatus);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        Direction direction = Direction.UP;
        instanceGame.startParty();
        Board instanceBoard = new Board();
        Square[][] squares
                = {{new Square(), new Square(), new Square(), new Square()},
                {new Square(), new Square(), new Square(), new Square()},
                {new Square(), new Square(), new Square(), new Square()},
                {new Square(), new Square(), new Square(), new Square()}};

        squares[0][0].setValue(2);
        squares[1][0].setValue(2);
        instanceBoard.setSquares(squares);

        instanceGame.setBoard(instanceBoard);
        instanceGame.move(direction);

        int expSquare0Result = 4;
        int square0Result = instanceGame.getBoard().getSquares()[0][0].getValue();

        assertEquals(expSquare0Result, square0Result);
    }

    /**
     * Test of updateStatus method, of class Game.
     */
    @Test
    public void testUpdateStatusWin() {
        System.out.println("updateStatus");
        instanceGame = new Game();
        instanceGame.startParty();
        Board instanceBoard = new Board();

        Square[][] squares
                = {{new Square(), new Square(), new Square(), new Square()},
                {new Square(), new Square(), new Square(), new Square()},
                {new Square(), new Square(), new Square(), new Square()},
                {new Square(), new Square(), new Square(), new Square()}};

        squares[0][0].setValue(2048);
        squares[2][2].setValue(2);
        instanceBoard.setSquares(squares);

        instanceGame.setBoard(instanceBoard);
        instanceGame.move(Direction.DOWN);

        LevelStatus expLvlStatusResult = LevelStatus.WIN;
        LevelStatus lvlStatusResult = instanceGame.getLevelStatus();
        assertEquals(expLvlStatusResult, lvlStatusResult);
    }

    /**
     * Test of updateStatus method, of class Game.
     */
    @Test
    public void testUpdateStatusFail() {
        System.out.println("updateStatus");
        instanceGame = new Game();
        instanceGame.startParty();
        Board instanceBoard = new Board();

        boolean expResult = false;
        boolean result = instanceBoard.checkFull();

        Square[][] squares
                = {{new Square(), new Square(), new Square(), new Square()},
                {new Square(), new Square(), new Square(), new Square()},
                {new Square(), new Square(), new Square(), new Square()},
                {new Square(), new Square(), new Square(), new Square()}};

        int nb1 = 2;
        int nb2 = 64;
        for (int lg = 0; lg < squares.length; lg++) {
            for (int col = 0; col < squares[0].length; col++) {
                if (lg % 2 == 0) {
                    nb1 *= 2;
                    squares[lg][col].setValue(nb1);
                } else {
                    nb2 /= 2;
                    squares[lg][col].setValue(nb2);
                }
            }
            nb1 = 2;
            nb2 = 64;
        }
        instanceBoard.setSquares(squares);

        instanceGame.setBoard(instanceBoard);
        instanceGame.updateStatus();

        LevelStatus expLvlStatusResult = LevelStatus.FAIL;
        LevelStatus lvlStatusResult = instanceGame.getLevelStatus();
        assertEquals(expLvlStatusResult, lvlStatusResult);
    }
}
