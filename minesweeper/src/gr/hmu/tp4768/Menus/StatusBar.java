package gr.hmu.tp4768.Menus;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
/**
 * @author tp4768
 * 
 * Minesweeper Status bar , which is a JPanel that displays a counter on the left and a counter on the right.
 * 
 */
public class StatusBar extends JPanel {
        public static int _minesLeft;
        public static int _flagsLeft;

        private JLabel _minesLeftLabel, _flagsLeftLabel;

        /**
         * constructor
         * @param minesLeft
         * @param flagsLeft
         */
        public StatusBar(int minesLeft, int flagsLeft) {
                _minesLeft = minesLeft;
                _flagsLeft = flagsLeft;
                initComponents();
                startTimer();
        }
    
        /**
        * Initialize the components of the status bar.
        */
        private void initComponents() {
            //set the size of the status bar
            setSize(new Dimension(500, 50));
            //set the layout of the status bar
            setLayout(new GridLayout(1, 2));
            //set the background color of the status bar
            setBackground(Color.LIGHT_GRAY);
            //set the font of the status bar
            Font font = new Font("Arial", Font.BOLD, 20);
            setFont(font);
            //add the mines left label to the left of the status bar
            _minesLeftLabel = new JLabel("Mines left: " + _minesLeft);
            add(_minesLeftLabel);
            //add the flags left label to the right of the status bar
            _flagsLeftLabel = new JLabel("Flags left: " + _flagsLeft);
            add(_flagsLeftLabel);    
        }

        /**
         * Function to initialize a timer to update the labels every second.
         */
        public void startTimer() {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    // update labels
                    _minesLeftLabel.setText("Mines left: " + _minesLeft);
                    _flagsLeftLabel.setText("Flags left: " + _flagsLeft);
                    //refresh the status bar
                    repaint();
                }
            }, 0, 1000);
        }

        
        // Setters
        public void setMinesLeft(int minesLeft) {
            StatusBar._minesLeft = minesLeft;
        }

        public void setFlagsLeft(int flagsLeft) {
            StatusBar._flagsLeft = flagsLeft;
        }

    
    
}
