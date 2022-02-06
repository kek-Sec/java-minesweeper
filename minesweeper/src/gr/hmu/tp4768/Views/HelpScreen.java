package gr.hmu.tp4768.Views;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//import borderlayout
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
//import color
import java.awt.Color;

/**
 * @author tp4768
 * 
 * HelpScreen is a message box that displays the help text.
 * The help text is displayed in a scrollable text area.
 * The help text contains the rules of the game (minesweeper).
 * 
 * @see GameFrame
 * 
 */
public class HelpScreen extends JPanel{
        
        private static final long serialVersionUID = 1L;
        
        private JPanel helpPanel;
        private JPanel textPanel;
        private JPanel buttonPanel;
        private JButton okButton;
        private JTextArea helpText;
        
        /**
        * constructor
        */
        public HelpScreen(){
            
            //create the help panel
            helpPanel = new JPanel();
            helpPanel.setLayout(new BorderLayout());
            
            //create the text panel
            textPanel = new JPanel();
            textPanel.setLayout(new BorderLayout());
            
            //create the button panel
            buttonPanel = new JPanel();
            buttonPanel.setLayout(new BorderLayout());
            
            //create the ok button
            okButton = new JButton("OK");
            okButton.setPreferredSize(new Dimension(100, 30));
            okButton.setFont(new Font("Arial", Font.BOLD, 12));
            okButton.setBackground(Color.LIGHT_GRAY);
            okButton.setForeground(Color.BLACK);
            
            //create the help text
            helpText = new JTextArea();
            helpText.setEditable(false);
            helpText.setFont(new Font("Arial", Font.BOLD, 12));
            helpText.setBackground(Color.LIGHT_GRAY);
            helpText.setForeground(Color.BLACK);
            helpText.setText(this.getHelpText());

            //add the help text to the text panel
            textPanel.add(helpText, BorderLayout.CENTER);

            //add the ok button to the button panel
            buttonPanel.add(okButton, BorderLayout.CENTER);

            //add the text panel and button panel to the help panel
            helpPanel.add(textPanel, BorderLayout.CENTER);
            helpPanel.add(buttonPanel, BorderLayout.SOUTH);

            //add the help panel to the help screen
            this.add(helpPanel, BorderLayout.CENTER);

            
        }

        /**
         * Function to get the help text.
         * 
         * @return the help text
         */
        private String getHelpText() {
            String helpText = "";
            helpText += "Welcome to Minesweeper!\n\n";
            helpText += "The objective of the game is to clear all the cells without\n";
            helpText += "revealing any of the mines.\n\n";
            helpText += "To clear a cell, click on it.\n\n";
            helpText += "To mark a cell as a flag, right-click on it and then\n";

            return helpText;
        }

}