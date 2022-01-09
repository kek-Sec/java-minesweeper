package gr.hmu.tp4768.Menus;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author tp4768
 * 
 * Extends JToolBar to create a toolbar, to be placed on top of the Board with the following buttons:
 * New Game, Save Game, Load Game, Exit, Help, About.
 */
public class GameToolBar extends javax.swing.JToolBar {

    /**
     * Buttons
     */
    private JButton _NewGameButton, _SaveGameButton, _LoadGameButton, _ExitButton, _HelpButton, _AboutButton;
    private JFrame _parent;

    public GameToolBar() {
        initComponents();
    }

    /**
     * Function to initialize the components of the game toolbar.
     */
    private void initComponents() {
        //create buttons
        _NewGameButton = new JButton("New Game");
        _SaveGameButton = new JButton("Save Game");
        _LoadGameButton = new JButton("Load Game");
        _ExitButton = new JButton("Exit");
        _HelpButton = new JButton("Help");
        _AboutButton = new JButton("About");

        //add buttons to toolbar
        this.add(_NewGameButton);
        this.add(_SaveGameButton);
        this.add(_LoadGameButton);
        this.add(_ExitButton);
        this.add(_HelpButton);
        this.add(_AboutButton);

        //add action listeners

        //place toolbar on top of the parent frame
        this.setFloatable(false);
        this.setOrientation(javax.swing.SwingConstants.VERTICAL);
        this.setRollover(true);
        this.setVisible(true);
    }
}