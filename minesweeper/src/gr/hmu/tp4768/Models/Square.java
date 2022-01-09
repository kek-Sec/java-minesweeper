package gr.hmu.tp4768.Models;
/**
 * @author tp4768
 * Model describing a minesweeper square.
 * Contains all the information about the square.
 */
public class Square {
    private boolean isMine;
    private boolean isRevealed;
    private boolean isFlagged;
    private int adjacentMines;
    
    /**
     * Constructor for the square.
     * @param isMine
     * @param isRevealed
     * @param isFlagged
     * @param adjacentMines
     */
    public Square(boolean isMine, boolean isRevealed, boolean isFlagged, int adjacentMines) {
        this.isMine = isMine;
        this.isRevealed = isRevealed;
        this.isFlagged = isFlagged;
        this.adjacentMines = adjacentMines;
    }
    
    /**
     * @return the isMine
     */
    public boolean isMine() {
        return isMine;
    }
    /**
     * @param isMine the isMine to set
     */
    public void setMine(boolean isMine) {
        this.isMine = isMine;
    }
    /**
     * @return the isRevealed
     */
    public boolean isRevealed() {
        return isRevealed;
    }
    /**
     * @param isRevealed the isRevealed to set
     */
    public void setRevealed(boolean isRevealed) {
        this.isRevealed = isRevealed;
    }
    /**
     * @return the isFlagged
     */
    public boolean isFlagged() {
        return isFlagged;
    }
    /**
     * @param isFlagged the isFlagged to set
     */
    public void setFlagged(boolean isFlagged) {
        this.isFlagged = isFlagged;
    }
    /**
     * @return the adjacentMines
     */
    public int getAdjacentMines() {
        return adjacentMines;
    }
    /**
     * @param adjacentMines the adjacentMines to set
     */
    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

}
