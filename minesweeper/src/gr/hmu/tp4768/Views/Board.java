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

import gr.hmu.tp4768.Menus.GameToolBar;
import gr.hmu.tp4768.Models.GameMode;

public class Board extends JPanel{

    private GameMode _gameMode;
    private int _rows;
    private int _columns;
    private JButton[][] _buttons;

    /**
     * constructor
     */
    public Board(GameMode gameMode){
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
    private void createBoard(){
        setLayout(new BorderLayout());
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(_rows, _columns));
        _buttons = new JButton[_rows][_columns];
        for(int i = 0; i < _rows; i++){
            for(int j = 0; j < _columns; j++){
                _buttons[i][j] = new JButton();
                _buttons[i][j].setPreferredSize(new Dimension(30, 30));
                _buttons[i][j].setBackground(Color.LIGHT_GRAY);
                _buttons[i][j].setFont(new Font("Arial", Font.BOLD, 20));
                _buttons[i][j].setEnabled(false);
                boardPanel.add(_buttons[i][j]);
            }
        }
        add(boardPanel, BorderLayout.CENTER);
    }

} 