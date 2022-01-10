package gr.hmu.tp4768.Listeners.Menus;

import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * @author tp4768
 *         Listeners for game toolbar buttons
 *         The buttons are:
 *         New Game, Save Game, Load Game, Exit, Help, About.
 */
public class GameToolBarListener {
    /**
     * Function to handle the New Game button being clicked.
     * @param parent The parent JFrame
     */
    public ActionListener actionPerformedNewGame(JFrame parent) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Do stuff
                //close parent
                parent.dispose();
            }
        };
    }

    /**
     * Function to handle the Save Game button being clicked.
     * @param parent The parent JFrame
     */
    public ActionListener actionPerformedSaveGame(JFrame parent) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Do stuff
                //close parent
                parent.dispose();
            }
        };
    }

    /**
     * Function to handle the Load Game button being clicked.
     * @param parent The parent JFrame
     */
    public ActionListener actionPerformedLoadGame(JFrame parent) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Do stuff
                //close parent
                parent.dispose();
            }
        };
    }

    /**
     * Function to handle the Exit button being clicked.
     * @param parent The parent JFrame
     */
    public ActionListener actionPerformedExit(JFrame parent) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Do stuff
                //close parent
                parent.dispose();
            }
        };
    }

    /**
     * Function to handle the Help button being clicked.
     * @param parent The parent JFrame
     */
    public ActionListener actionPerformedHelp(JFrame parent) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Do stuff
                //close parent
                parent.dispose();
            }
        };
    }

    /**
     * Function to handle the About button being clicked.
     * @param parent The parent JFrame
     */
    public ActionListener actionPerformedAbout(JFrame parent) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Do stuff
                //close parent
                parent.dispose();
            }
        };
    }
}
