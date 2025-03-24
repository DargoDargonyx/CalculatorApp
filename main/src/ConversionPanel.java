package src;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is used to make the currency conversion portion
 * of the calculator app.
 * 
 * @author DargoDargonyx
 * @author Tencianity
 * @version 03.24.25
 */
public class ConversionPanel {
    
    private JPanel mainPanel;
    private JPanel inputPanel;
    private JPanel outputPanel;

    public ConversionPanel() {

        initializeInnerPanels();

    }
    private JPanel getMainPanel() {

        return this.mainPanel;

    }
    private void initializeInnerPanels() {

        initializeInput();
        initializeOutput();

    }
    private void initializeInput() {

        inputPanel = new JPanel();
        inputPanel.setName("inputPanel");

        JPanel namePanel = new JPanel();
        namePanel.setName("inNamePanel");

        JLabel nameLabel = new JLabel("Input");

        namePanel.add(nameLabel);
        inputPanel.add(namePanel, BorderLayout.PAGE_START);
        mainPanel.add(inputPanel);

    }
    private void initializeOutput() {

        outputPanel = new JPanel();
        outputPanel.setName("outputPanel");

        JPanel namePanel = new JPanel();
        namePanel.setName("outNamePanel");

        JLabel nameLabel = new JLabel("Output");

        namePanel.add(nameLabel);
        inputPanel.add(namePanel, BorderLayout.PAGE_START);
        mainPanel.add(outputPanel);

    }

}
