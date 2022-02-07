package gr.hmu.tp4768.Views;

/**
 * @author tp4768
 *
 * Board is a class that extends JPanel and is the main view of the game.
 * It receives the game mode as input and creates the board according to the
 * game mode.
 *
 * @see JPanel
 * @see GameMode
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import gr.hmu.tp4768.Listeners.Views.BoardListener;
import gr.hmu.tp4768.Menus.GameToolBar;
import gr.hmu.tp4768.Models.Game;
import gr.hmu.tp4768.Models.GameMode;
import gr.hmu.tp4768.Models.Square;

public class Board extends JPanel {

    private GameMode _gameMode;
    private int _rows;
    private int _columns;
    private Square[][] _squares;
    private Game _game;
    private BoardListener _boardListener;

    /**
     * constructor
     */
    public Board(GameMode gameMode) {
        _boardListener = new BoardListener();
        _game = new Game();
        _gameMode = gameMode;
        _rows = _gameMode.getNumberOfRows();
        _columns = _gameMode.getNumberOfRows();
        createBoard();
    }

    /**
     * Function to create the board according to the rows and columns counts.
     * Create one new button for each cell and add it to the board.
     *
     * @see JButton
     * @see GameToolBar
     *
     */
    private void createBoard() {
        setLayout(new BorderLayout());
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(_rows, _columns));
        _squares = new Square[_rows][_columns];
        // create a new button for each cell and add it to the board
        for (int i = 0; i < _rows; i++) {
            for (int j = 0; j < _columns; j++) {
                _squares[i][j] = new Square();
                JButton button = new JButton();
                button.setBackground(Color.LIGHT_GRAY);
                button.setFont(new Font("Arial", Font.BOLD, 20));
                button.setPreferredSize(new Dimension(30, 30));
                button.setEnabled(true);
                boardPanel.add(button);
                _squares[i][j].setButton(button);
                // add the listener to the button
                // add listener to right click
                button.addMouseListener(_boardListener.rightClick(_squares, i, j, _game));

            }
        }
        // populate the board with mines , update Game
        _squares = _game.populateGrid(_gameMode, _squares);
        add(boardPanel, BorderLayout.CENTER);
        // start the timer
        startTimer();
    }

    /**
     * Create a timer that checks every second if the game is over.
     *
     */
    public void startTimer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (_game.checkGameOver(_squares)) {
                        GameOver gameOver = new GameOver(true);
                    }
                }
            }
        }).start();
    }
}