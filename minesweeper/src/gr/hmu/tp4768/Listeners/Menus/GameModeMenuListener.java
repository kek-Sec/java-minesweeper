package gr.hmu.tp4768.Listeners.Menus;

import gr.hmu.tp4768.GameController;
import gr.hmu.tp4768.Models.Difficulty;
import gr.hmu.tp4768.Models.GameMode;

/**
 * @author tp4768
 * 
 * Listener for the game mode menu.
 */
public class GameModeMenuListener implements java.awt.event.ActionListener {
    
    /**
     * @param e
     * @return
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        //if button name is Easy
        if(e.getActionCommand().equals("Easy")){
            //set game mode to easy
            GameController.setGameMode(new GameMode(Difficulty.EASY)); 
        }
        //if button name is Medium
        else if(e.getActionCommand().equals("Medium")){
            //set game mode to medium
            GameController.setGameMode(new GameMode(Difficulty.MEDIUM));
        }
        //if button name is Hard
        else if(e.getActionCommand().equals("Hard")){
            //set game mode to hard
            GameController.setGameMode(new GameMode(Difficulty.HARD));
        }
        else{
            return;
        }
    }
}