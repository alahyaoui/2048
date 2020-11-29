/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54895.atl.project.controller;

import g54895.atl.project.model.Direction;
import g54895.atl.project.model.LevelStatus;
import g54895.atl.project.model.Model;
import g54895.atl.project.view.ViewGUI;
import java.beans.PropertyChangeListener;
import java.util.Objects;

/**
 *
 * @author Ayoub
 */
public class ControllerGUI {

    private Model game;
    private ViewGUI view;

    /**
     * Simple constructor of the controller
     *
     * @param game
     * @param view
     */
    public ControllerGUI(Model game, ViewGUI view) {
        Objects.requireNonNull(game);
        Objects.requireNonNull(view);
        this.game = game;
        this.view = (ViewGUI) view;
    }

    /**
     * Method startGame , starts the game
     */
    public void startGame() {
        game.startParty();
    }

    /**
     * Method TryMove ,tries the move.
     *
     * @param direction a Direction
     */
    public void tryMove(Direction direction) {
        try {
            if (game.getLevelStatus() == LevelStatus.IN_PROGRESS) {
                game.change(direction);
                view.updateBoard();    
            }else{
                checkLevelStatus();
            }          
        } catch (IllegalArgumentException e) {
            game.checkStatus();
            view.displayError("mouvement impossible !!!");          
        }
    }

    public void tryRestart() { 
        try {
            game.restartParty();
            game.change();
            view.createBoard();
        } catch (IllegalArgumentException e) {
            view.displayError("restart impossible !!!");
        }
    }

    /**
     * Method checkLevelStatus , check the status of the level if Win increments
     * the level if Fail restart the level
     */
    private void checkLevelStatus() {
        switch (game.getLevelStatus()) {
            case WIN:
                view.displayWin();
                break;
            case FAIL:
                view.displayFail();
                break;
            default:
                view.displayError("Erreur dans le statut du niveau");
        }
    }

    public void addModelListener(PropertyChangeListener listener) {
        game.addPropertyChangeListener(listener);
        game.change();
    }
}
