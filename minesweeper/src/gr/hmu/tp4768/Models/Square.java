package gr.hmu.tp4768.Models;

import javax.swing.JButton;

/**
 * @author tp4768
 *         Model describing a minesweeper square.
 *         Contains all the information about the square.
 */
public class Square {
    private boolean isMine;
    private boolean isRevealed;
    private boolean isFlagged;
    private int adjacentMines;
    private JButton button;

    /**
     * Constructor for the square.
     * 
     * @param isMine
     * @param isRevealed
     * @param isFlagged
     * @param adjacentMines
     * @param button
     */
    public Square(boolean isMine, boolean isRevealed, boolean isFlagged, int adjacentMines, JButton button) {
        this.isMine = isMine;
        this.isRevealed = isRevealed;
        this.isFlagged = isFlagged;
        this.adjacentMines = adjacentMines;
        this.button = button;
    }

    /**
     * Empty constructor for the square.
     */
    public Square() {
        this.isMine = false;
        this.isRevealed = false;
        this.isFlagged = false;
        this.adjacentMines = 0;
        this.button = null;
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
        if (!isRevealed) {
            this.clearButton();
        }
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

    /**
     * set the button of the square.
     * 
     * @param button
     */
    public void setButton(JButton button) {
        this.button = button;
    }

    /**
     * Function to set button text to the adjacentMines.
     */
    public void setButtonText() {
        this.button.setText(Integer.toString(this.adjacentMines));
    }

    /**
     * @return the button
     */
    public JButton getButton() {
        return button;
    }

    /**
     * Function to clear the button text and make it disabled and dark gray.
     */
    public void clearButton() {
        this.button.setText("");
        this.button.setEnabled(false);
        this.button.setBackground(java.awt.Color.DARK_GRAY);
    }

    /**
     * Function to set the button text to F with a red outline.
     */
    public void setFlag() {
        this.button.setText("F");
        this.button.setForeground(java.awt.Color.RED);
    }

    /**
     * Function to set the button text to M with a red background and white text.
     */
    public void setMine() {
        this.button.setText("M");
        this.button.setBackground(java.awt.Color.RED);
        this.button.setForeground(java.awt.Color.WHITE);
    }

}
