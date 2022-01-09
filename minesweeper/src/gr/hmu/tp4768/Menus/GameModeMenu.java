package gr.hmu.tp4768.Menus;

import javax.swing.JButton;
import javax.swing.JPanel;

import gr.hmu.tp4768.Listeners.Menus.GameModeMenuListener;
import gr.hmu.tp4768.Models.GameModes;

/**
 * @author tp4768
 * 
 * class that extends JPanel, and displays the game mode menu. Based on GameModes enum.
 */
public class GameModeMenu extends JPanel {

    GameModeMenuListener _MenuListener;
    GameModes _GameMode;
    /**
     * Menu buttons
     */
     JButton _EasyButton, _MediumButton, _HardButton;

    /**
     * Creates new
     * form GameModeMenu
     * @param gameMode
     * @param gameModeMenuListener
     */
    public GameModeMenu(GameModes gameMode, GameModeMenuListener gameModeMenuListener) {
        initComponents();
        _GameMode = gameMode;
        _MenuListener = gameModeMenuListener;
        this.setVisible(true);
    }

    /**
     * Function to initialize the components of the game mode menu.
     */
    public void initComponents(){
        _EasyButton = new JButton("Easy");
        _EasyButton.addActionListener(_MenuListener);
        _EasyButton.setActionCommand("Easy");
        _EasyButton.setBounds(50, 50, 100, 50);
        this.add(_EasyButton);

        _MediumButton = new JButton("Medium");
        _MediumButton.addActionListener(_MenuListener);
        _MediumButton.setActionCommand("Medium");
        _MediumButton.setBounds(50, 150, 100, 50);
        this.add(_MediumButton);

        _HardButton = new JButton("Hard");
        _HardButton.addActionListener(_MenuListener);
        _HardButton.setActionCommand("Hard");
        _HardButton.setBounds(50, 250, 100, 50);
        this.add(_HardButton);
    }
}
