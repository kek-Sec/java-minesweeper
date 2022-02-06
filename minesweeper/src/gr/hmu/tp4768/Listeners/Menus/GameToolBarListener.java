package gr.hmu.tp4768.Listeners.Menus;

import javax.swing.JFrame;

import gr.hmu.tp4768.App;
import gr.hmu.tp4768.Menus.GameModeMenu;
import gr.hmu.tp4768.Views.HelpScreen;
import gr.hmu.tp4768.Views.SplashScreen;

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
                SplashScreen splashScreen = new SplashScreen();
                splashScreen.setVisible(true);
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
                //parent.dispose()

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
                //create a new jframe with HelpScreen panel as content
                JFrame helpFrame = new JFrame("Help");
                helpFrame.setContentPane(new HelpScreen());
                helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                helpFrame.pack();
                helpFrame.setVisible(true);

                
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
