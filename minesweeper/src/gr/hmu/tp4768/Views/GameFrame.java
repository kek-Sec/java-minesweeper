package gr.hmu.tp4768.Views;

import javax.swing.JFrame;

import gr.hmu.tp4768.Menus.GameToolBar;
import gr.hmu.tp4768.Menus.StatusBar;
import gr.hmu.tp4768.Models.GameMode;
import java.awt.BorderLayout;
import java.awt.Dimension;
/**
 * @author tp4768
 * 
 * GameFrame extends JFrame and creates the main window of the game.
 * It consists of , a game tool bar, a board and a status bar.
 * 
 */
public class GameFrame extends JFrame{
    
    private GameMode _gameMode;
    /**
     * constructor
     */
    public GameFrame(GameMode gameMode){
        _gameMode = gameMode;
        setTitle("Minesweeper");
        initComponents();
        setSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Function to initialize the components of the game frame.
     * At the the top of the frame is the game tool bar.
     * At the bottom of the frame is the status bar.
     * At the center of the frame is the board.
     */
    public void initComponents(){
        GameToolBar gameToolBar = new GameToolBar();
        Board board = new Board(this._gameMode);
        StatusBar statusBar = new StatusBar(99,99);
        add(gameToolBar, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }
}
