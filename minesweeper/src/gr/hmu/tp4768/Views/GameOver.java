package gr.hmu.tp4768.Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

/**
 * @author tp4768
 *
 *         GameOver screen , when the game is over.
 *         Accepts a boolean as input , if the game is won or lost.
 *         Shows the message according to the boolean and asks the user to play
 *         again.
 *
 */
public class GameOver extends JFrame {

    private boolean _isWon;

    /**
     * Constructor for the game over screen.
     * 
     * @param isWon
     */
    public GameOver(boolean isWon) {
        _isWon = isWon;
        setTitle("Game Over");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setBackground(Color.BLACK);
        if (_isWon) {
            // create panel
            JPanel panel = new JPanel();
            panel.setBounds(0, 0, 300, 200);
            panel.setBackground(Color.BLACK);
            add(panel);
            // create label
            JLabel label = new JLabel("You Won!");
            label.setBounds(100, 50, 100, 100);
            label.setForeground(Color.GREEN);
            label.setFont(new Font("Arial", Font.BOLD, 20));
            panel.add(label);
            // create button
            JButton button = new JButton("Play Again");
            button.setBounds(100, 100, 100, 30);
            button.setBackground(Color.GREEN);
            button.setForeground(Color.BLACK);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    SplashScreen splashScreen = new SplashScreen();
                }
            });
        } else {
            // create panel
            JPanel panel = new JPanel();
            panel.setBounds(0, 0, 300, 200);
            panel.setBackground(Color.BLACK);
            add(panel);
            // create label
            JLabel label = new JLabel("You Lost!");
            label.setBounds(100, 50, 100, 100);
            label.setForeground(Color.RED);
            label.setFont(new Font("Arial", Font.BOLD, 20));
            panel.add(label);
            // create button
            JButton button = new JButton("Play Again");
            button.setBounds(100, 100, 100, 30);
            button.setBackground(Color.RED);
            button.setForeground(Color.BLACK);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    SplashScreen splashScreen = new SplashScreen();
                }
            });
        }
    }

}
