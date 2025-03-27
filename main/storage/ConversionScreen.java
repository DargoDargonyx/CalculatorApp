package storage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
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
    
    private final JPanel screen;
    private JPanel inputPanel;
    private JPanel outputPanel;
    private JPanel sideBarPanel;
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
        initializeSideBar();

        JSplitPane firstPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, inputPanel, outputPanel);
        firstPane.setResizeWeight(0.7);
        firstPane.setDividerLocation(0.7);
        firstPane.setDividerSize(1);
        firstPane.setEnabled(false);

        JSplitPane secondPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, firstPane, sideBarPanel);
        secondPane.setResizeWeight(0.7);
        secondPane.setDividerLocation(0.7);
        secondPane.setDividerSize(1);
        secondPane.setEnabled(false);

        JButton toggleButton = new JButton("Hide Sidebar");
        int buttonHeight = (int) (inputPanel.getHeight() * 0.25);
        int buttonWidth = (int) (inputPanel.getWidth() * 0.4);
        toggleButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        screen.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {

                int newHeight = screen.getHeight();
                int topPanelHeight = (int) (newHeight * 0.7);
                firstPane.setDividerLocation(topPanelHeight);

                int newWidth = screen.getWidth();
                int firstPaneWidth = (int) (newWidth * 0.7);
                secondPane.setDividerLocation(firstPaneWidth);

                int buttonHeight = (int) (inputPanel.getHeight() * 0.25);
                int buttonWidth = (int) (inputPanel.getWidth() * 0.4);
                toggleButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

            }
        });

        toggleButton.addActionListener(new ActionListener() {
            
            private boolean sideBarVisible = true;

            @Override
            public void actionPerformed(ActionEvent e) {

                if (sideBarVisible) {
                    
                    secondPane.setDividerLocation(1.0);
                    toggleButton.setText("Show Sidebar");

                }
                else {

                    int newWidth = screen.getWidth();
                    int firstPaneWidth = (int) (newWidth * 0.7);
                    secondPane.setDividerLocation(firstPaneWidth);
                    toggleButton.setText("Hide Sidebar");

                }
                sideBarVisible = !sideBarVisible;

            }

        });

        inputPanel.add(toggleButton, BorderLayout.LINE_END);
        screen.add(secondPane, BorderLayout.CENTER);

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

    private void initializeSideBar() {

        sideBarPanel = new JPanel();
        sideBarPanel.add(new JLabel("Sidebar Content"));

    }

}
