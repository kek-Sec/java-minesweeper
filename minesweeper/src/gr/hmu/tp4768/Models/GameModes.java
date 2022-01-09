package gr.hmu.tp4768.Models;
/**
 * @author tp4768
 * 
 * Enum with all possible difficulties.
 */
public enum GameModes {
    EASY, MEDIUM, HARD;

    /**
     * constructor
     */
    private GameModes() {
    }

    /**
     * @return the difficulty
     */
    public String getDifficulty() {
        switch (this) {
            case EASY:
                return "Easy";
            case MEDIUM:
                return "Medium";
            case HARD:
                return "Hard";
            default:
                return "";
        }
    }

    /**
     * @return the number of mines per difficulty
     */
    public int getMines() {
        switch (this) {
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
     * @return the number of rows per difficulty
     */
    public int getRows() {
        switch (this) {
            case EASY:
                return 9;
            case MEDIUM:
                return 16;
            case HARD:
                return 16;
            default:
                return 0;
        }
    }

    /**
     * @return the number of columns per difficulty
     */
    public int getColumns() {
        switch (this) {
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
}


