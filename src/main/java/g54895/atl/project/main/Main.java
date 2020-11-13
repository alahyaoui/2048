/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54895.atl.project.main;

import g54895.atl.project.controller.Controller;
import g54895.atl.project.model.Game;
import g54895.atl.project.view.View;

/**
 *
 * @author Ayoub
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        controller.startGame();
    }
}
