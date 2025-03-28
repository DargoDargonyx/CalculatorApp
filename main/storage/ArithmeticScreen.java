package storage;
import javax.script.Compilable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    private static final String resultPreamble = "Result: ";
    private String result;

    private JPanel buttonJPanel;
    private JPanel biggerJPanel;
    private JPanel operatorJPanel;

    public ArithmeticScreen() {

        // Must be in this order (I think)
        createMainPanel();
        initializeButtons();
        initializeSubPanels();

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

    @SuppressWarnings("static-access")
    private void initializeButtons() {

        
        // Create button panel
        buttonJPanel = new JPanel();
        buttonJPanel.setName("buttonPanel");
        buttonJPanel.setLayout(new GridLayout(3, 3));
        
        biggerJPanel = new JPanel();
        biggerJPanel.setName("biggerPanel");
        biggerJPanel.setLayout(new BoxLayout(biggerJPanel, BoxLayout.Y_AXIS));

        GridBagConstraints g = new GridBagConstraints();
        
        /* Make 0 - 9 buttons in a for loop creating button objects with name and function
        linked to incrementing variable "i" */
        String num = "";
        for (int i = 1; i <= 10; i++) {

            // Create "0" button when i is 10 so it is the last button created and placed into panel
            if (i == 10) {
                num = "0";
            }
            else {
                num = Integer.toString(i);
            }

            // Create new button with String num as the label
            JButton button = new JButton(num);

            /* Have to do this shit for some reason to be able to use the num variable in the addActionListener class;
            Compilation error otherwise, but just sets a new variable called "numb" equal to the variable "num" */
            String numb = num;

            button.addActionListener(new ActionListener() {
                /**
                 * Action of pressing each button pastes its number (0-9) to the inputJTextField
                 * @param event The event that occurs
                 */
                public void actionPerformed(ActionEvent event) {
                    inputJTextField.setText(inputJTextField.getText() + numb);
                    System.out.println(button.getSize());
                }
            });

            // Place the zero button into the bigger panel seperately from the rest of the number panel
            if (i == 10) {
                biggerJPanel.add(buttonJPanel);
                button.setSize(new Dimension(123, 26));
                biggerJPanel.add(button, g.gridy);
                button.setAlignmentX(biggerJPanel.CENTER_ALIGNMENT); // Align "0" button to the center of biggerJPanel
                break;
            }
            else {
                buttonJPanel.add(button, g); // Add created button to buttonJPanel
            }
        }

        operatorJPanel = new JPanel();
        operatorJPanel.setName("operatorPanel");

        // "+" Button
        // "-" Button
        // "*" Button
        // "/" Button

        // "power (exponent)" Button

        // "=" Button
        JButton equalsButton = new JButton();
        equalsButton.setName("Equals");
        equalsButton.setText("Equals");
        equalsButton.addActionListener(new ActionListener() {

            /**
             * 
             * @param event Button is pressed
             */
            public void actionPerformed(ActionEvent event) {
                System.out.print(inputJTextField.getText() + " = ");
                updateResult();
                System.out.println(result);
            }

        });

        mainPanel.add(biggerJPanel); // Add biggerJPanel to mainPanel
        mainPanel.add(equalsButton); // Add equalsButton to mainPanel
    }

    public void updateResult() {
        result = calculateString();
        resultJLabel.setText(resultPreamble + result);
    }

    public String calculateString() {
        
        return "";

    }

    public Double charToDouble(char c)
    {
        return Double.parseDouble(String.valueOf(c));
    }
}
