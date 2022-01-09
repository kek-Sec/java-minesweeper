package gr.hmu.tp4768.Views;

import javax.swing.JFrame;

/**
 * @author tp4768
 * 
 * Class that extends JFrame , and displays the splash screen with a menu to choose the game mode. Based on GameModes enum.
 */
public class SplashScreen extends JFrame {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor for the splash screen.
     */
    public SplashScreen() {
        setTitle("Minesweeper");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
    