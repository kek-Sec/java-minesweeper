package gr.hmu.tp4768.Menus;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gr.hmu.tp4768.Listeners.Menus.GameModeMenuListener;
import gr.hmu.tp4768.Views.SplashScreen;

/**
 * @author tp4768
 * 
 * class that extends JPanel, and displays the game mode menu. Based on GameModes enum.
 */
public class GameModeMenu extends JPanel {

    JFrame _Parent;
    GameModeMenuListener _MenuListener;
    /**
     * Menu buttons
     */
     JButton _EasyButton, _MediumButton, _HardButton;
     //label
     JLabel _Label;

    /**
     * Creates new
     * form GameModeMenu
     * @param gameModeMenuListener
     */
    public GameModeMenu(JFrame ParentFrame) {
        _Parent = ParentFrame;
        initComponents();
        this.setVisible(true);
    }

    /**
     * Function to initialize the components of the game mode menu.
     * Action Handling is done in a seperate class but keep in mind that we pass the parent JFrame to the action handler
     * in order to be able to close the parent frame. when the user clicks on a button.
     */
    public void initComponents(){
        _MenuListener = new GameModeMenuListener();
        //add label
        _Label = new JLabel("Choose Game Mode      ");
        this.add(_Label);
        //add buttons below label
        _EasyButton = new JButton("Easy");
        _EasyButton.addActionListener(_MenuListener.actionPerformedEasy(this._Parent));
        this.add(_EasyButton);
        _MediumButton = new JButton("Medium");
        _MediumButton.addActionListener(_MenuListener.actionPerformedMedium(this._Parent));
        this.add(_MediumButton);
        _HardButton = new JButton("Hard");
        _HardButton.addActionListener(_MenuListener.actionPerformedHard(this._Parent));
        this.add(_HardButton);
    }
}
