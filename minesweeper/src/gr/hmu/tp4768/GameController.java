package gr.hmu.tp4768;

import gr.hmu.tp4768.Models.GameMode;

/**
 * @author tp4768
 * 
 * Game controller is a static class that contains the game variables.
 */
public class GameController {
    private static GameMode gameMode;

    /**
     * Function to update the game mode.
     */
    public static void setGameMode(GameMode gameMode) {
        GameController.gameMode = gameMode;
        //print that the game mode has been changed and the new game mode
        System.out.println("Game mode changed to " + gameMode.getDifficulty());
    }

    /**
     * Function to get the game mode.
     */
    public static GameMode getGameMode() {
        return gameMode;
    }

}
