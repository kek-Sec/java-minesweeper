package gr.hmu.tp4768.Models;
/**
 * @author tp4768
 * 
 * Enum with all possible difficulties.
 */
public class GameMode {
    private Difficulty _difficulty;

    /**
     * constructor
     */
    public GameMode(Difficulty difficulty){
        _difficulty = difficulty;
    }

    /**
     * getter
     */
    public Difficulty getDifficulty(){
        return _difficulty;
    }

    /**
     * setter
     */
    public void setDifficulty(Difficulty difficulty){
        _difficulty = difficulty;
    }

    /**
     * Get the number of mines in the game based on the difficulty
     */
    public int getNumberOfMines(){
        switch(_difficulty){
            case EASY:
                return 10;
            case MEDIUM:
                return 40;
            case HARD:
                return 99;
            default:
                return 0;
        }
    }

    /**
     * Get the number of rows in the game based on the difficulty
     */
    public int getNumberOfRows(){
        switch(_difficulty){
            case EASY:
                return 9;
            case MEDIUM:
                return 16;
            case HARD:
                return 30;
            default:
                return 0;
        }
    }

    /**
     * Get the number of columns in the game based on the difficulty
     */
    public int getNumberOfColumns(){
        switch(_difficulty){
            case EASY:
                return 9;
            case MEDIUM:
                return 16;
            case HARD:
                return 30;
            default:
                return 0;
        }
    }

    /**
     * Get number of flags in the game based on the difficulty
     */
    public int getNumberOfFlags(){
        switch(_difficulty){
            case EASY:
                return 10;
            case MEDIUM:
                return 40;
            case HARD:
                return 99;
            default:
                return 0;
        }
    }
}


