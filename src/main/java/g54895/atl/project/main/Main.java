package g54895.atl.project.main;

import g54895.atl.project.controller.Controller;
import g54895.atl.project.model.Game;
import g54895.atl.project.view.View;

/**
 * The main of the 2048 project.
 *
 * @author Ayoub
 */
public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        controller.startGame();
    }
}
