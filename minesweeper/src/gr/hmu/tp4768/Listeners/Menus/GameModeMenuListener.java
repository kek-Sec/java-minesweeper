package gr.hmu.tp4768.Listeners.Menus;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gr.hmu.tp4768.GameController;
import gr.hmu.tp4768.Models.Difficulty;
import gr.hmu.tp4768.Models.GameMode;

/**
 * @author tp4768
 * 
 * Listener for the game mode menu.
 */
public class GameModeMenuListener {
    

    /**
     * Action listener to catch easy button press.
     */
    public ActionListener actionPerformedEasy() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set game mode to easy
                GameController.setGameMode(new GameMode(Difficulty.EASY));
            }
        };
    }

    /**
     * Action listener to catch medium button press.
     */
    public ActionListener actionPerformedMedium() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set game mode to medium
                GameController.setGameMode(new GameMode(Difficulty.MEDIUM));
            }
        };
    }

    /**
     * Action listener to catch hard button press.
     */
    public ActionListener actionPerformedHard() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set game mode to hard
                GameController.setGameMode(new GameMode(Difficulty.HARD));
            }
        };
    }
}