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
    public static boolean first_run = true; //indicate if we should actually show the splash screen

    /**
     * Creates new form SplashScreen
     * 
     */
    public SplashScreen() {
        initComponents();
        this.setVisible(true);
    }

    /**
     * Function to initialize the components of the splash screen.
     * Show the splash screen for 2 seconds.
     * Then show the game mode menu.
     */
    public void initComponents() {
       
        _GameModeMenu = new GameModeMenu(this);
        //hide controls
        this.setUndecorated(true);
        this.setSize(180, 180);
        //center the frame
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (SplashScreen.first_run) {
            SplashScreen.first_run = false;
            this.setContentPane(new JPanel() {
                @Override
                public void paintComponent(java.awt.Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(new javax.swing.ImageIcon(image).getImage(), 0, 0, null);
                }
            });
            this.setVisible(true);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        this.setVisible(false);
        this.setContentPane(_GameModeMenu);
        this.setSize(200,140);
        this.setVisible(true);
    }

}
