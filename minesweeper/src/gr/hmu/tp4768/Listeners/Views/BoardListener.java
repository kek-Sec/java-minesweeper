package gr.hmu.tp4768.Listeners.Views;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gr.hmu.tp4768.Models.Square;

import java.awt.event.ActionEvent;
/**
 * @author tp4768
 * 
 *         ActionListeners for the board buttons
 *         Every board button is a minesweeper square. defined in Square.java
 *         This class contains the logic for the minesweeper squares.
 */
public class BoardListener {

    /**
     * Function to handle the button being clicked.
     * 
     * @param parent The parent JFrame
     * 
     */
    public ActionListener actionPerformed(Square square) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Do stuff
               
            }
        };
    }
}
