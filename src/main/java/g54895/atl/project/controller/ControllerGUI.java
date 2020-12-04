package g54895.atl.project.controller;

import g54895.atl.project.model.Direction;
import g54895.atl.project.model.LevelStatus;
import g54895.atl.project.model.Model;
import g54895.atl.project.view.ViewGUI;
import java.beans.PropertyChangeListener;
import java.util.Objects;

/**
 * The GUI controller part of the MVC structure.
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
            checkLevelStatus(); 
        }
    }

    /**
     * Method tryRestart, tries to restart the game.
     */
    public void tryRestart() { 
        try {
            game.restartParty();
            game.change();
            view.updateBoard();
            view.displayError("Partie recommencée");
        } catch (IllegalArgumentException e) {
            view.displayError("Restart impossible !!!");
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
            case IN_PROGRESS:     
                view.displayError("Mouvement impossible !!!");         
                break;
            case NOT_STARTED:
                view.displayError("La partie n'a pas encore commencé");
                break;
            default:
                view.displayError("Erreur dans le statut du niveau");
        }
    }

    /**
     * Method addModelListener, adds a listener to the listenable and 
     * immediately fire to him.
     * @param listener a PropertyChangeListener.
     */
    public void addModelListener(PropertyChangeListener listener) {
        game.addPropertyChangeListener(listener);
        game.change();
    }
}
