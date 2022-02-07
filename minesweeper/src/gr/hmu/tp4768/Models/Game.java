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
    public boolean isGameOver = false;

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
     * On the squares at the edge of the grid we need to check the adjacent squares
     * and display the number of adjacent mines.
     *
     * @param row
     * @param column
     * @param grid
     */
    public void revealAdjacentSquares(int row, int column, Square[][] grid) {
        // get the number of adjacent mines
        int adjacentMines = grid[row][column].getAdjacentMines();
        // if the adjacent mines is 0, reveal the adjacent squares
        if (adjacentMines == 0) {
            // check if all adjacent squares are revealed
            if (this.checkAdjacentSquares(row, column, grid)) {
                // reveal the square
                grid[row][column].setRevealed(true);
                // clear button
                grid[row][column].clearButton();
                return;
            }
            // check the adjacent squares
            if (row > 0) {
                if (column > 0) {
                    if (!grid[row - 1][column - 1].isRevealed()) {
                        grid[row - 1][column - 1].setRevealed(true);
                        grid[row - 1][column - 1].clearButton();
                        revealAdjacentSquares(row - 1, column - 1, grid);
                    }
                }
                if (!grid[row - 1][column].isRevealed()) {
                    grid[row - 1][column].setRevealed(true);
                    revealAdjacentSquares(row - 1, column, grid);
                }
                if (column < columns - 1) {
                    if (!grid[row - 1][column + 1].isRevealed()) {
                        grid[row - 1][column + 1].setRevealed(true);
                        grid[row - 1][column + 1].clearButton();
                        revealAdjacentSquares(row - 1, column + 1, grid);
                    }
                }
            }
            if (column > 0) {
                if (!grid[row][column - 1].isRevealed()) {
                    grid[row][column - 1].setRevealed(true);
                    grid[row][column - 1].clearButton();
                    revealAdjacentSquares(row, column - 1, grid);
                }
            }
            if (column < columns - 1) {
                if (!grid[row][column + 1].isRevealed()) {
                    grid[row][column + 1].setRevealed(true);
                    grid[row][column + 1].clearButton();
                    revealAdjacentSquares(row, column + 1, grid);
                }
            }
            if (row < rows - 1) {
                if (column > 0) {
                    if (!grid[row + 1][column - 1].isRevealed()) {
                        grid[row + 1][column - 1].setRevealed(true);
                        grid[row + 1][column - 1].clearButton();
                        revealAdjacentSquares(row + 1, column - 1, grid);
                    }
                }
                if (!grid[row + 1][column].isRevealed()) {
                    grid[row + 1][column].setRevealed(true);
                    revealAdjacentSquares(row + 1, column, grid);
                }
                if (column < columns - 1) {
                    if (!grid[row + 1][column + 1].isRevealed()) {
                        grid[row + 1][column + 1].setRevealed(true);
                        grid[row + 1][column + 1].clearButton();
                        revealAdjacentSquares(row + 1, column + 1, grid);
                    }
                }
            }
        } else {
            grid[row][column].setRevealed(true);
            grid[row][column].setAdjacentMines(adjacentMines);
            grid[row][column].setButtonText();
        }
    }

    /**
     * Function to display all the squares that are mines.
     *
     * @param Square[][]
     *
     */
    public void displayMines(Square[][] Grid) {
        // update GameOver
        this.isGameOver = true;
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
    public int getAdjacentMines(int i, int j, Square[][] grid2) {
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

        return adjacentMines;
    }

    /**
     * Function to check if all adjacent squares have been revealed
     *
     * @param row
     * @param column
     * @param grid
     *
     */
    public boolean checkAdjacentSquares(int row, int column, Square[][] grid) {
        // check if the square to the left of the current square is a mine
        if (column - 1 >= 0) {
            // check if the square to the left of the current square is a mine
            if (grid[row][column - 1].isRevealed()) {
                return true;
            }
        }
        // check if the square to the right of the current square is a mine
        if (column + 1 < grid[0].length) {
            // check if the square to the right of the current square is a mine
            if (grid[row][column + 1].isRevealed()) {
                return true;
            }
        }
        // check if the square above the current square is a mine
        if (row - 1 >= 0) {
            // check if the square above the current square is a mine
            if (grid[row - 1][column].isRevealed()) {
                return true;
            }
        }
        // check if the square below the current square is a mine
        if (row + 1 < grid.length) {
            // check if the square below the current square is a mine
            if (grid[row + 1][column].isRevealed()) {
                return true;
            }
        }
        // check the square to the left of the current square, check that is not out of
        // bounds
        if (column - 1 >= 0) {
            // check if the square to the left of the current square is a mine
            if (grid[row][column - 1].isRevealed()) {
                return true;
            }
        }
        // check the square to the right of the current square, check that is not out of
        // bounds
        if (column + 1 < grid[0].length) {
            // check if the square to the right of the current square is a mine
            if (grid[row][column + 1].isRevealed()) {
                return true;
            }
        }
        // check the square above the current square, check that is not out of bounds
        if (row - 1 >= 0) {
            // check if the square above the current square is a mine
            if (grid[row - 1][column].isRevealed()) {
                return true;
            }
        }
        // check the square below the current square, check that is not out of bounds
        if (row + 1 < grid.length) {
            // check if the square below the current square is a mine
            if (grid[row + 1][column].isRevealed()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Function to check if game is over,
     * if all squares are either revealed or flagged
     *
     * @param grid
     * @return true if game is over, false if not
     */
    public boolean checkGameOver(Square[][] grid) {
        // set max number of rows
        int maxRows = grid.length;
        // set max number of columns
        int maxColumns = grid[0].length;
        // set number of mines
        int mines = 0;
        // set number of revealed squares
        int revealedSquares = 0;
        // set number of flagged squares
        int flaggedSquares = 0;
        // loop through the grid
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxColumns; j++) {
                // check if the square is a mine
                if (grid[i][j].isMine()) {
                    mines++;
                }
                // check if the square is revealed
                if (grid[i][j].isRevealed()) {
                    revealedSquares++;
                }
                // check if the square is flagged
                if (grid[i][j].isFlagged()) {
                    flaggedSquares++;
                }
            }
        }
        // check if the number of mines equals the number of flagged squares
        if (mines == flaggedSquares) {
            // check if the number of revealed squares equals the number of squares
            // minus the number of mines
            if (revealedSquares == (maxRows * maxColumns) - mines) {
                this.isGameOver = true;
                return true;
            }
        }
        this.isGameOver = false;
        return false;
    }
}
