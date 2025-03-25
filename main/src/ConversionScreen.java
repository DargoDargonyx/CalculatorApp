package src;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * This class is used to make the currency conversion portion
 * of the calculator app.
 * 
 * @author DargoDargonyx
 * @author Tencianity
 * @version 03.24.25
 */
public class ConversionPanel implements Screen {
    
    private JPanel mainPanel;
    private JPanel inputPanel;
    private JPanel outputPanel;
    private Border border;

    public ConversionPanel() {

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        border = BorderFactory.createLineBorder(Color.BLACK, 2);
        mainPanel.setBorder(border);
        initializeInnerPanels();

    }
    public JPanel getMainPanel() {

        return this.mainPanel;

    }
    private void initializeInnerPanels() {

        initializeInput();
        //initializeOutput();

    }
    private void initializeInput() {

        GridBagConstraints gbcInput = new GridBagConstraints();
        inputPanel = new JPanel();
        inputPanel.setName("inputPanel");

        border = BorderFactory.createLineBorder(Color.BLUE, 1);
        inputPanel.setBorder(border);
        gbcInput.weightx = 1.0;
        gbcInput.weighty = 0.5;
        gbcInput.fill = GridBagConstraints.BOTH;;

        /*
        GridBagConstraints gbcLabel = new GridBagConstraints();
        JLabel nameLabel = new JLabel("Input");
        border = BorderFactory.createLineBorder(Color.RED, 1);
        nameLabel.setBorder(border);
        gbcLabel.gridx = 1;
        gbcLabel.gridy = 1;
        gbcLabel.fill = GridBagConstraints.BOTH;
        inputPanel.add(nameLabel, gbcLabel);
        */
        
        GridBagConstraints gbcOutput = new GridBagConstraints();
        outputPanel = new JPanel();
        outputPanel.setName("outputPanel");

        border = BorderFactory.createLineBorder(Color.BLUE, 1);
        outputPanel.setBorder(border);
        gbcOutput.weightx = 1.0;
        gbcOutput.weighty = 0.5;
        gbcOutput.fill = GridBagConstraints.BOTH;

        mainPanel.add(outputPanel, gbcOutput);
        mainPanel.add(inputPanel, gbcInput);
        
        
    }

    private void initializeOutput() {

        GridBagConstraints gbcOutput = new GridBagConstraints();
        outputPanel = new JPanel();
        outputPanel.setName("outputPanel");

        border = BorderFactory.createLineBorder(Color.BLUE, 1);
        outputPanel.setBorder(border);
        gbcOutput.weightx = 1.0;
        gbcOutput.weighty = 0.5;
        gbcOutput.fill = GridBagConstraints.BOTH;
        
        /*
        JLabel nameLabel = new JLabel("Output");
        GridBagConstraints gbcLabel = new GridBagConstraints();
        border = BorderFactory.createLineBorder(Color.RED, 1);
        nameLabel.setBorder(border);
        gbcLabel.gridx = 1;
        gbcLabel.gridy = 1;
        gbcLabel.fill = GridBagConstraints.BOTH;
        outputPanel.add(nameLabel, gbcLabel);
        */

        mainPanel.add(outputPanel, gbcOutput);

    }

}
