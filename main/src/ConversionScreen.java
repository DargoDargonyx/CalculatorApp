package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.Border;

/**
 * This class is used to make the currency conversion portion
 * of the calculator app.
 * 
 * @author DargoDargonyx
 * @author Tencianity
 * @version 03.24.25
 */
public class ConversionScreen {
    
    private JPanel screen;
    private JPanel inputPanel;
    private JPanel outputPanel;
    private Border border;

    public ConversionScreen() {

        screen = new JPanel();
        screen.setLayout(new BorderLayout());
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

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, inputPanel, outputPanel);
        splitPane.setResizeWeight(0.7);
        splitPane.setDividerLocation(0.7);
        splitPane.setDividerSize(1);
        splitPane.setEnabled(false);
        screen.add(splitPane, BorderLayout.CENTER);

        screen.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {

                int newHeight = screen.getHeight();
                int topPanelHeight = (int) (newHeight * 0.7);
                splitPane.setDividerLocation(topPanelHeight);

            }
        });

    }
    private void initializeInput() {

        inputPanel = new JPanel();
        inputPanel.setName("inputPanel");

        border = BorderFactory.createLineBorder(Color.BLUE, 1);
        inputPanel.setBorder(border);
        
    }

    private void initializeOutput() {

        outputPanel = new JPanel();
        outputPanel.setName("outputPanel");

        border = BorderFactory.createLineBorder(Color.BLUE, 1);
        outputPanel.setBorder(border);

    }

}
