/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54895.atl.project.controller;

import g54895.atl.project.model.Direction;
import g54895.atl.project.model.LevelStatus;
import g54895.atl.project.model.Model;
import g54895.atl.project.view.InterfaceView;

/**
 * The controller part of the MVC structure.
 *
 * @author Ayoub.
 */
public class Controller {

    private Model game;
    private InterfaceView view;

    /**
     * Simple constructor of the controller
     *
     * @param game
     * @param view
     */
    public Controller(Model game, InterfaceView view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Method startGame , starts the game
     */
    public void startGame() {
        game.startParty();
        while (game.getLevelStatus() == LevelStatus.IN_PROGRESS) {
            view.displayBoard(game.getBoard());
            Direction direction = checkDirection(view.askDirection());
            game.move(direction);
        }
        checkLevelStatus();
    }

    /**
     * Method TryMove ,tries the move.
     *
     * @param direction a Direction
     */
    private void tryMove(Direction direction) {
        try {
            game.move(direction);
        } catch (IllegalArgumentException e) {
            view.displayError("mouvement impossible !!!");
        }
    }

    /**
     * Method checkDirection, checks the integer given in parameter and send the
     * Direction corresponding.
     *
     * @param direction an integer form of the Direction.
     * @return a Direction.
     */
    private Direction checkDirection(int direction) {
        switch (direction) {
            case 5:
                return Direction.UP;
            case 2:
                return Direction.DOWN;
            case 3:
                return Direction.RIGHT;
            case 1:
                return Direction.LEFT;
            default:
                return Direction.UP;
        }
    }

    /**
     * Method checkLevelStatus , check the status of the level if Win increments
     * the level if Fail restart the level
     */
    private void checkLevelStatus() {
        switch (game.getLevelStatus()) {
            case IN_PROGRESS:
                view.displayMessage("La partie est en cours");
                break;
            case WIN:
                view.displayMessage("Vous avez gagné !");
                break;
            case FAIL:
                view.displayMessage("Vous avez perdu !");
                break;
            case NOT_STARTED:
                view.displayMessage("La partie n'a pas commencé");
                break;
            default:
                view.displayError("Erreur dans le statut du niveau");
        }
    }
}
