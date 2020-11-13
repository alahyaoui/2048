/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54895.atl.project.view;

import g54895.atl.project.model.Board;

/**
 *
 * @author Ayoub
 */
public interface InterfaceView {

    void displayBoard(Board board);

    public int askDirection();

    public void displayError(String err);
}
