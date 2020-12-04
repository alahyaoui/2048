package g54895.atl.project.view;

import g54895.atl.project.model.Board;

/**
 * Interface InterfaceView, the view interface of the MVC structure.
 *
 * @author Ayoub
 */
public interface InterfaceView {

    /**
     * Method displayBoard, displays the board and its content.
     *
     * @param board a Board.
     */
    void displayBoard(Board board);

    /**
     * Method askDirection , asks the direction and return it.
     *
     * @return a integer direction.
     */
    public int askDirection();

    /**
     * Method displayError, displays a message of error
     *
     * @param message a String.
     */
    public void displayError(String err);

    /**
     * Method displayMessage, displays the message in parameter.
     *
     * @param message a String.
     */
    public void displayMessage(String message);
}
