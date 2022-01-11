package gr.hmu.tp4768.Models;
/**
 * @author tp4768
 * 
 * Model describing all the information about a running minesweeper game.
 * Contains information such as,
 * - the number of mines in the game
 * - the number of mines left to find
 * - the number of mines flagged
 * - the number of mines revealed
 * - the number of rows and columns in the game
 * - the number of mines in each row and column
 * 
 * In Grid array we store all the squares in the game. By row 
 */
public class Game {
    private int mines;
    private int minesLeft;
    private int minesFlagged;
    private int minesRevealed;
    private int rows;
    private int columns;
    private Square[][] Grid;
    
    /**
     * Constructor for the game.
     * @param mines
     * @param minesLeft
     * @param minesFlagged
     * @param minesRevealed
     * @param rows
     * @param columns
     * @param Grid
     */
    public Game(int mines, int minesLeft, int minesFlagged, int minesRevealed, int rows, int columns, Square[][] Grid) {
        this.mines = mines;
        this.minesLeft = minesLeft;
        this.minesFlagged = minesFlagged;
        this.minesRevealed = minesRevealed;
        this.rows = rows;
        this.columns = columns;
        this.Grid = Grid;
    }
    
    /**
     * @return the mines
     */
    public int getMines() {
        return mines;
    }
    /**
     * @param mines the mines to set
     */
    public void setMines(int mines) {
        this.mines = mines;
    }
    /**
     * @return the minesLeft
     */
    public int getMinesLeft() {
        return minesLeft;
    }
    /**
     * @param minesLeft the minesLeft to set
     */
    public void setMinesLeft(int minesLeft) {
        this.minesLeft = minesLeft;
    }
    /**
     * @return the minesFlagged
     */
    public int getMinesFlagged() {
        return minesFlagged;
    }
    /**
     * @param minesFlagged the minesFlagged to set
     */
    public void setMinesFlagged(int minesFlagged) {
        this.minesFlagged = minesFlagged;
    }
    /**
     * @return the minesRevealed
     */
    public int getMinesRevealed() {
        return minesRevealed;
    }

    /**
     * @param minesRevealed the minesRevealed to set
     */
    public void setMinesRevealed(int minesRevealed) {
        this.minesRevealed = minesRevealed;
    }

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return the columns
     */
    public int getColumns(){
        return this.columns;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    /**
     * @return the Grid
     */
    public Square[][] getGrid() {
        return Grid;
    }

    /**
     * @param Grid the Grid to set
     */
    public void setGrid(Square[][] Grid) {
        this.Grid = Grid;
    }

    /**
     * Function to populate the Grid with squares based on the GameMode difficulty
     * 
     * @param gameMode
     */
    public Square[][] populateGrid(GameMode gamemode,Square[][] Grid){
        //get the number of mines in the game
        int mines = gamemode.getNumberOfMines();
        this.mines = mines;
        //get the number of rows in the game
        int rows = gamemode.getNumberOfRows();
        this.rows = rows;
        //get the number of columns in the game
        int columns = gamemode.getNumberOfColumns();
        this.columns = columns;
        //place the mines in the grid randomly
        for(int i = 0; i < mines; i++){
            int row = (int)(Math.random()*rows);
            int column = (int)(Math.random()*columns);
            Grid[row][column].setMine(true);
        }
        //set the number of mines left to find
        this.minesLeft = mines;
        //set the number of mines flagged
        this.minesFlagged = 0;
        //set the number of mines revealed
        this.minesRevealed = 0;
        //return the grid
        return Grid;
        
    }

    
}
