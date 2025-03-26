package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
public class ConversionScreen implements Screen {
    
    private JPanel screen;
    private JPanel inputPanel;
    private JPanel outputPanel;
    private Border border;

    public ConversionScreen() {

        screen = new JPanel();
        screen.setLayout(new BoxLayout(screen, BoxLayout.Y_AXIS));
        border = BorderFactory.createLineBorder(Color.BLACK, 2);
        screen.setBorder(border);
        initializeInnerPanels();

    }
    public JPanel getScreen() {

        return this.screen;

    }
    private void initializeInnerPanels() {

        initializeInput();
        initializeOutput();

    }
    private void initializeInput() {

        inputPanel = new JPanel();
        inputPanel.setName("inputPanel");

        border = BorderFactory.createLineBorder(Color.BLUE, 1);
        inputPanel.setBorder(border);

        screen.add(inputPanel);
        
        
    }

    private void initializeOutput() {

        GridBagConstraints gbcOutput = new GridBagConstraints();
        outputPanel = new JPanel();
        outputPanel.setName("outputPanel");

        border = BorderFactory.createLineBorder(Color.BLUE, 1);
        outputPanel.setBorder(border);

        screen.add(outputPanel);

    }

}
