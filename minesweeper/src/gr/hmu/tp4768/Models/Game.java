package gr.hmu.tp4768.Models;

/**
 * @author tp4768
 * 
 *         Model describing all the information about a running minesweeper
 *         game.
 *         Contains information such as,
 *         - the number of mines in the game
 *         - the number of mines left to find
 *         - the number of mines flagged
 *         - the number of mines revealed
 *         - the number of rows and columns in the game
 *         - the number of mines in each row and column
 * 
 *         In Grid array we store all the squares in the game. By row
 */
public class Game {
    private int rows;
    private int columns;
    private Square[][] Grid;

    /**
     * Constructor for the game.
     * 
     * @param mines
     * @param minesLeft
     * @param minesFlagged
     * @param minesRevealed
     * @param rows
     * @param columns
     * @param Grid
     */
    public Game(int rows, int columns, Square[][] Grid) {
        this.rows = rows;
        this.columns = columns;
        this.Grid = Grid;
    }

    /**
     * Empty constructor for the game.
     * 
     * @return
     */
    public Game() {
        this.rows = 0;
        this.columns = 0;
        this.Grid = null;
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
    public int getColumns() {
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
     * Function to reveal adjacent squares that have no adjacent mines.
     * Make sure that we do not go out of bounds.
     * 
     * @param row
     * @param column
     * @param grid
     */
    public void revealAdjacentSquares(int row, int column, Square[][] grid) {
        System.out.println("Revealing adjacent squares");
        if (row > 0 && row < grid.length - 1 && column > 0 && column < grid[0].length - 1) {
            if (grid[row - 1][column - 1].isRevealed() == false && grid[row - 1][column - 1].isMine() == false && grid[row - 1][column - 1].isFlagged() == false && grid[row - 1][column - 1].getAdjacentMines() == 0) {
                grid[row - 1][column - 1].clearButton();
                revealAdjacentSquares(row - 1, column - 1, grid);
            }
            if (grid[row - 1][column].isRevealed() == false && grid[row - 1][column].isMine() == false && grid[row - 1][column].isFlagged() == false && grid[row - 1][column].getAdjacentMines() == 0) {
                grid[row - 1][column].clearButton();
                revealAdjacentSquares(row - 1, column, grid);
            }
            if (grid[row - 1][column + 1].isRevealed() == false && grid[row - 1][column + 1].isMine() == false && grid[row - 1][column + 1].isFlagged() == false && grid[row - 1][column + 1].getAdjacentMines() == 0) {
                grid[row - 1][column + 1].clearButton();
                revealAdjacentSquares(row - 1, column + 1, grid);
            }
            if (grid[row][column - 1].isRevealed() == false && grid[row][column - 1].isMine() == false && grid[row][column - 1].isFlagged() == false && grid[row][column - 1].getAdjacentMines() == 0) {
                grid[row][column - 1].clearButton();
                revealAdjacentSquares(row, column - 1, grid);
            }
            if (grid[row][column + 1].isRevealed() == false && grid[row][column + 1].isMine() == false && grid[row][column + 1].isFlagged() == false && grid[row][column + 1].getAdjacentMines() == 0) {
                grid[row][column + 1].clearButton();
                revealAdjacentSquares(row, column + 1, grid);
            }
            if (grid[row + 1][column - 1].isRevealed() == false && grid[row + 1][column - 1].isMine() == false && grid[row + 1][column - 1].isFlagged() == false && grid[row + 1][column - 1].getAdjacentMines() == 0) {
                grid[row + 1][column - 1].clearButton();
                revealAdjacentSquares(row + 1, column - 1, grid);
            }
            if (grid[row + 1][column].isRevealed() == false && grid[row + 1][column].isMine() == false && grid[row + 1][column].isFlagged() == false && grid[row + 1][column].getAdjacentMines() == 0) {
                grid[row + 1][column].clearButton();
                revealAdjacentSquares(row + 1, column, grid);
            }
            if (grid[row + 1][column + 1].isRevealed() == false && grid[row + 1][column + 1].isMine() == false && grid[row + 1][column + 1].isFlagged() == false && grid[row + 1][column + 1].getAdjacentMines() == 0) {
                grid[row + 1][column + 1].clearButton();
                revealAdjacentSquares(row + 1, column + 1, grid);
            }
        }
    
    }

    /**
     * Function to display all the squares that are mines.
     * 
     * @param Square[][]
     * 
     */
    public void displayMines(Square[][] Grid) {
        //print text
        System.out.println("Mines:");

        for (int i = 0; i < Grid.length; i++) {
            for (int j = 0; j < Grid[i].length; j++) {
                if (Grid[i][j].isMine()) {
                    Grid[i][j].setMine();
                } else {

                }
            }
        }
    }

    /**
     * Function to populate the Grid with squares based on the GameMode difficulty
     * 
     * @param gameMode
     */
    public Square[][] populateGrid(GameMode gamemode, Square[][] Grid) {
        // get the number of mines in the game
        int mines = gamemode.getNumberOfMines();
        // get the number of rows in the game
        int rows = gamemode.getNumberOfRows();
        this.rows = rows;
        // get the number of columns in the game
        int columns = gamemode.getNumberOfColumns();
        this.columns = columns;
        // place the mines in the grid randomly
        for (int i = 0; i < mines; i++) {
            int row = (int) (Math.random() * rows);
            int column = (int) (Math.random() * columns);
            Grid[row][column].setMine(true);
        }
        // update the adjacent mines for each square
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Grid[i][j].setAdjacentMines(getAdjacentMines(i, j, Grid));
            }
        }
        // set grid
        this.Grid = Grid;
        // return the grid
        return Grid;

    }

    /**
     * Function to get the number of adjacent mines for a square, the max number of
     * adjacent mines is 8
     * 
     * @param i     row
     * @param j     column
     * @param grid2 the grid
     * @return
     */
    private int getAdjacentMines(int i, int j, Square[][] grid2) {
        int adjacentMines = 0;
        // set max number of rows
        int maxRows = grid2.length;
        // set max number of columns
        int maxColumns = grid2[0].length;
        // check the square above the current square, check that is not out of bounds
        if (i - 1 >= 0) {
            // check the square to the left of the current square, check that is not out of
            // bounds
            if (j - 1 >= 0) {
                // check if the square to the left of the current square is a mine
                if (grid2[i - 1][j - 1].isMine()) {
                    adjacentMines++;
                }
            }
            // check the square to the right of the current square, check that is not out of
            // bounds
            if (j + 1 < maxColumns) {
                // check if the square to the right of the current square is a mine
                if (grid2[i - 1][j + 1].isMine()) {
                    adjacentMines++;
                }
            }
            // check if the square above the current square is a mine
            if (grid2[i - 1][j].isMine()) {
                adjacentMines++;
            }
        }
        // check the square below the current square, check that is not out of bounds
        if (i + 1 < maxRows) {
            // check the square to the left of the current square, check that is not out of
            // bounds
            if (j - 1 >= 0) {
                // check if the square to the left of the current square is a mine
                if (grid2[i + 1][j - 1].isMine()) {
                    adjacentMines++;
                }
            }
            // check the square to the right of the current square, check that is not out of
            // bounds
            if (j + 1 < maxColumns) {
                // check if the square to the right of the current square is a mine
                if (grid2[i + 1][j + 1].isMine()) {
                    adjacentMines++;
                }
            }
            // check if the square below the current square is a mine
            if (grid2[i + 1][j].isMine()) {
                adjacentMines++;
            }
        }
        // check the square to the left of the current square, check that is not out of
        // bounds
        if (j - 1 >= 0) {
            // check if the square to the left of the current square is a mine
            if (grid2[i][j - 1].isMine()) {
                adjacentMines++;
            }
        }
        // check the square to the right of the current square, check that is not out of
        // bounds
        if (j + 1 < maxColumns) {
            // check if the square to the right of the current square is a mine
            if (grid2[i][j + 1].isMine()) {
                adjacentMines++;
            }
        }
        // check the diagonal top left square, check that is not out of bounds
        if (i - 1 >= 0 && j - 1 >= 0) {
            // check if the diagonal top left square is a mine
            if (grid2[i - 1][j - 1].isMine()) {
                adjacentMines++;
            }
        }
        // check the diagonal top right square, check that is not out of bounds
        if (i - 1 >= 0 && j + 1 < maxColumns) {
            // check if the diagonal top right square is a mine
            if (grid2[i - 1][j + 1].isMine()) {
                adjacentMines++;
            }
        }
        // check the diagonal bottom left square, check that is not out of bounds
        if (i + 1 < maxRows && j - 1 >= 0) {
            // check if the diagonal bottom left square is a mine
            if (grid2[i + 1][j - 1].isMine()) {
                adjacentMines++;
            }
        }
        // check the diagonal bottom right square, check that is not out of bounds
        if (i + 1 < maxRows && j + 1 < maxColumns) {
            // check if the diagonal bottom right square is a mine
            if (grid2[i + 1][j + 1].isMine()) {
                adjacentMines++;
            }
        }
        return adjacentMines;
    }
}
