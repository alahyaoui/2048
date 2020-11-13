/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54895.atl.project.model;

/**
 *
 * @author Ayoub
 */
public interface Model {
    
    public void startParty();
    
    public void move(Direction direction);
    
    public void restartParty();
    
    public void updateStatus();

    public LevelStatus getLevelStatus();

    public Board getBoard();
    
}
