package gr.hmu.tp4768.Listeners.Views;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gr.hmu.tp4768.Models.Game;
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
    public ActionListener actionPerformed(Square[][] squares,int row,int col,Game game) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get the square that was clicked
                Square square = squares[row][col];
                //prety print the square
                System.out.println(square.toString());
                //if the square is not flagged
                if(!square.isFlagged()) {
                    //if the square is not revealed
                    if(!square.isRevealed()) {
                        //if the square is a mine
                        if(square.isMine()) {
                            //reveal all the mines
                            game.displayMines(squares);
                            //show the game over dialog
                            return;
                        }
                        //if the square is not a mine
                        else {
                            //if the square is not a mine and has no adjacent mines
                            if(square.getAdjacentMines() == 0) {
                                //reveal all the adjacent squares
                                game.revealAdjacentSquares(row, col, squares);
                            }
                            //if the square is not a mine and has adjacent mines
                            else {
                                //reveal the square
                                square.setButtonText();
                            }
                        }
                    }
                }
               
            }
        };
    }
}
