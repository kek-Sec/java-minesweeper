package gr.hmu.tp4768.Views;
/**
 * @author tp4768
 * 
 * Board is a class that extends JFrame and is the main view of the game.
 * It receives the game mode as input and creates the board according to the
 * game mode.
 * 
 * @see JFrame
 * @see GameMode
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gr.hmu.tp4768.Models.GameMode;

public class Board extends JFrame{

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
     */
    public void createBoard(){
        //set the size of the board
        setSize(new Dimension(300, 300));
        //set the title of the board
        setTitle("Minesweeper");
        //set the layout of the board
        setLayout(new BorderLayout());
        //set the background color of the board
        getContentPane().setBackground(Color.LIGHT_GRAY);
        //set the font of the board
        setFont(new Font("Arial", Font.BOLD, 20));
        //create the buttons
        _buttons = new JButton[_rows][_columns];
        //create the grid layout
        GridLayout gridLayout = new GridLayout(_rows, _columns);
        //set the grid layout to the board
        setLayout(gridLayout);
        //create the buttons
        for(int i = 0; i < _rows; i++){
            for(int j = 0; j < _columns; j++){
                //create a new button
                JButton button = new JButton();
                //set the size of the button
                button.setPreferredSize(new Dimension(30, 30));
                //set the font of the button
                button.setFont(new Font("Arial", Font.BOLD, 20));
                //add the button to the board
                add(button);
                //add the button to the buttons array
                _buttons[i][j] = button;
            }
        }
        //add the action listener to the buttons
        //addActionListener();

        //set the visibility of the board
        pack();
        setVisible(true);
    }

} 