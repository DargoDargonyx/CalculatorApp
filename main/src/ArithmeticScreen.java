package src;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * FrameArithmetic.java
 * Calculator Framework
 * 
 * @author Dargo Dargonyx
 * @author Tencianity
 * @version 03.24.25
 */

public class ArithmeticScreen implements Screen {
    private  static String NAME = "Arithmetic Calculator";

    private JPanel mainPanel;
    private JPanel inputJPanel;
    private JTextField inputJTextField;

    private JPanel outputJPanel;
    private JLabel resultJLabel;
    private static String resultPreamble = "Result\n>>>";

    private JPanel buttonJPanel;

    public ArithmeticScreen() {

        // Must be in this order (I think)
        createMainPanel();
        initializeSubPanels();
        initializeButtons();

    }

    public JPanel getScreen() {
        return mainPanel;
    }

    public String getName() {
        return NAME;
    }

    private void createMainPanel() {

        // Create main panel and set name to Arithmetic Panel
        mainPanel = new JPanel();
        mainPanel.setName("Arithmetic Panel");

    }

    private void initializeSubPanels() {

        // Create input panel
        inputJPanel = new JPanel();
        inputJPanel.setName("inputPanel");

        // Add black border around input panel
        Border inputBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        inputJPanel.setBorder(inputBorder);

        // Create JTextField and add to inputJPanel
        inputJTextField = new JTextField(10);
        inputJPanel.add(inputJTextField);

        // Create output panel
        outputJPanel = new JPanel();
        outputJPanel.setName("outputPanel");

        // Add yellow background to output panel
        outputJPanel.setBackground(Color.YELLOW);

        // Create result label and add to outputJPanel
        resultJLabel = new JLabel(resultPreamble);
        outputJPanel.add(resultJLabel);

        // Add all subpanels to main panel
        mainPanel.add(inputJPanel);
        mainPanel.add(outputJPanel);

    }

    private void initializeButtons() {
        // Create button panel
        buttonJPanel = new JPanel();
        buttonJPanel.setName("buttonPanel");

        // Try to make 0 - 9 buttons in a for loop creating button objects with name and function
        // linked to incrementing variable "i"

        for (int i = 1; i <= 9; i++) {

            String num = Integer.toString(i); // get i as a string

            // Create new button with text i as the label
            JButton button = new JButton(num);

            button.addActionListener(new ActionListener() {
                /**
                 * Action of pressing each button pastes its number (0-9) to the inputJTextField
                 * @param event The event that occurs
                 */
                public void actionPerformed(ActionEvent event) {
                    inputJTextField.setText(inputJTextField.getText() + num);
                }
            });
            buttonJPanel.setLayout(new GridLayout());
            buttonJPanel.add(button); // Add button to buttonJPanel
            
        }

        // "+" Button
        // "-" Button
        // "*" Button
        // "/" Button

        // "power (exponent)" Button

        // "=" Button

        mainPanel.add(buttonJPanel); // Add buttonJPanel to mainPanel
    }

    public void updateResult(String result) {
        resultJLabel.setText(resultPreamble + result);
    }
}
