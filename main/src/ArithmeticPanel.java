package src;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import java.awt.Color;
import java.awt.event.InputMethodListener;

/**
 * FrameArithmetic.java
 * Calculator Framework
 * 
 * @author Dargo Dargonyx
 * @author Tencianity
 * @version 03.24.25
 */

public class ArithmeticPanel implements Screen {
    private  static String NAME = "Arithmetic Calculator";

    private JPanel mainPanel;
    private JPanel inputJPanel;
    private JLabel resultLabel;

    public ArithmeticPanel() {

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
        inputJPanel.setSize(500, 500);

        // Add black border around input panel
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        inputJPanel.setBorder(border);

        // Create JTextField and add to inputJPanel
        JTextField inputJTextField = new JTextField(10);
        inputJTextField.addActionListener(ButtonActionListener);
        inputJPanel.add(inputJTextField);

        // Add all subpanels to main panel
        mainPanel.add(inputJPanel);

    }

    private void initializeButtons() {
        // Try to make 0 - 9 buttons in a for loop creating button objects with name and function
        // linked to incrementing variable "i"

        // for (i from 0 to 9)
        // make new button
        // set button name to (str) i
        // format button
        // make button function add (str) i to input panel

        // "0" Button
        // "1" Button
        // "2" Button
        // "3" Button
        // "4" Button
        // "5" Button
        // "6" Button
        // "7" Button
        // "8" Button
        // "9" Button

        // "+" Button
        // "-" Button
        // "*" Button
        // "/" Button

        // "power (exponent)" Button

        // "=" Button
    }

}
