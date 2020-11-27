/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54895.atl.project.main;

import g54895.atl.project.controller.ControllerGUI;
import g54895.atl.project.model.Game;
import g54895.atl.project.view.ViewGUI;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Ayoub
 */
public class MainGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Game game = new Game();
        ViewGUI view = new ViewGUI(stage);
        ControllerGUI controller = new ControllerGUI(game, view);
        view.setController(controller);
        view.initialize();
        view.showStage();
    }
}
