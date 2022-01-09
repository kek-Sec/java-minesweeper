package gr.hmu.tp4768.Views;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gr.hmu.tp4768.Menus.GameModeMenu;

/**
 * @author tp4768
 * 
 *         Class that extends JFrame ,
 *         shows splash screen for 2 seconds and then shows the game mode menu.
 */
public class SplashScreen extends JFrame {

    GameModeMenu _GameModeMenu;
    private String image = "src/gr/hmu/tp4768/Resources/splash.png";

    /**
     * Creates new form SplashScreen
     * 
     * @param gameModeMenu
     */
    public SplashScreen(GameModeMenu gameModeMenu) {
        initComponents();
        _GameModeMenu = gameModeMenu;
        this.setVisible(true);
    }

    /**
     * Function to initialize the components of the splash screen.
     * Show the splash screen for 2 seconds.
     * Then show the game mode menu.
     */
    public void initComponents() {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        setContentPane(new JPanel() {
            @Override
            public void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                g.drawImage(new javax.swing.ImageIcon(image).getImage(), 0, 0, null);
            }
        });
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setVisible(false);
        _GameModeMenu.setVisible(true);
    }

}
