package gr.hmu.tp4768.Listeners.Views;

import gr.hmu.tp4768.Menus.StatusBar;
import gr.hmu.tp4768.Models.Game;
import javax.swing.SwingUtilities;
import gr.hmu.tp4768.Models.Square;
import java.awt.event.*;

/**
 * @author tp4768
 *
 *         MouseListener for the board buttons
 *         Every board button is a minesweeper square. defined in Square.java
 *         This class contains the logic for the minesweeper squares.
 */
public class BoardListener {
    /**
     * Listener for the JButton right click event
     *
     * @param squares
     * @param row
     * @param col
     * @param game
     *
     */
    public MouseListener rightClick(Square[][] squares, int row, int col, Game game) {
        return new MouseListener() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // if left click
                if (SwingUtilities.isLeftMouseButton(e)) {
                    // get the square that was clicked
                    Square square = squares[row][col];

                }
                // if right click
                if (SwingUtilities.isRightMouseButton(e)) {
                    // get the square that was clicked
                    Square square = squares[row][col];
                    // if the square is not revealed
                    if (!square.isRevealed()) {
                        // if the square is not flagged
                        if (!square.isFlagged()) {
                            // flag the square
                            square.setFlagged(true);
                            square.setFlag();
                            // decrease the number of flags
                            StatusBar._flagsLeft--;
                        }
                        // if the square is flagged
                        else {
                            // unflag the square
                            // if flagged
                            if (square.isFlagged()) {
                                square.setFlagged(false);
                                square.resetButton();
                                // increase the number of flags
                                StatusBar._flagsLeft++;
                            }
                        }
                    }
                    return;
                }
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }
        };
    }

}
