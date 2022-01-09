package gr.hmu.tp4768.Menus;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * @author tp4768
 * 
 * extends JMenuBar and creates a menu to be placed at the top of the Board with the following buttons:
 * New Game, Save Game, Load Game, Exit, Help, About.
 */
public class GameToolBar extends JMenuBar {

    /**
     * Buttons
     */
    private JButton _NewGameButton, _SaveGameButton, _LoadGameButton, _ExitButton, _HelpButton, _AboutButton;
    private JFrame _parent;

    public GameToolBar() {
        initComponents();
    }

    /**
     * Initialize the components of the menu bar.
     */
    private void initComponents() {
        // Create the menu bar.
        JMenuBar menuBar = new JMenuBar();

        // Create the menu.
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1, 6));

        // Create the buttons.
        _NewGameButton = new JButton("New Game");
        _SaveGameButton = new JButton("Save Game");
        _LoadGameButton = new JButton("Load Game");
        _ExitButton = new JButton("Exit");
        _HelpButton = new JButton("Help");
        _AboutButton = new JButton("About");

        // Add the buttons to the menu.
        menuPanel.add(_NewGameButton);
        menuPanel.add(_SaveGameButton);
        menuPanel.add(_LoadGameButton);
        menuPanel.add(_ExitButton);
        menuPanel.add(_HelpButton);
        menuPanel.add(_AboutButton);

        // Add the menu to the menu bar.
        menuBar.add(menuPanel);

        // Add the menu bar to the frame.
        add(menuBar);
    }
}
