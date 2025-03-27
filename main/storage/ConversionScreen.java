package storage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
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
    private boolean sideBarVisible;


    /**
     * This is the constructor for the class and it sets a border for
     * visibility as well initializing all the inner panels and adding
     * them to the screen.
     * 
     */
    public ConversionScreen() {

        screen = new JPanel();
        screen.setLayout(new BorderLayout());
        border = BorderFactory.createLineBorder(Color.BLACK, 2);
        screen.setBorder(border);
        initializeInnerPanels();
        

    }

    /**
     * This method will return the object of the screen
     * JPanel in case it is needed outside of the class.
     * 
     * @return This is the screen JPanel object.
     */
    public JPanel getScreen() {

        return this.screen;

    }

    /**
     * This method initializes the inner panels and then sets
     * them in their proper placing. This method also creates the
     * toggle button for the sidebar.
     * 
     */
    private void initializeInnerPanels() {

        // Initializes the original panels
        initializeInput();
        initializeOutput();
        initializeSideBar();

        // Makes a vertical split pane out of teh input and output panels
        JSplitPane firstPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, inputPanel, outputPanel);
        firstPane.setResizeWeight(0.7);
        firstPane.setDividerLocation(0.7);
        firstPane.setDividerSize(1);
        firstPane.setEnabled(false);

        // Makes a horizontal split pane out of the first split pane and the sidebar
        JSplitPane secondPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, firstPane, sideBarPanel);
        secondPane.setResizeWeight(0.7);
        secondPane.setDividerLocation(0.7);
        secondPane.setDividerSize(1);
        secondPane.setEnabled(false);
        sideBarVisible = true;

        // Makes the toggle button for the sidebar
        JButton toggleButton = new JButton("Hide Sidebar");
        int buttonHeight = (int) (inputPanel.getHeight() * 0.25);
        int buttonWidth = (int) (inputPanel.getWidth() * 0.4);
        toggleButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        screen.addComponentListener(new ComponentAdapter() {
            
            /**
             * This is the action lsitener for when the screen gets
             * resized by the user.
             * 
             */
            @Override
            public void componentResized(ComponentEvent e) {


                // Readjusts the input and output panels
                int newHeight = screen.getHeight();
                int topPanelHeight = (int) (newHeight * 0.7);
                firstPane.setDividerLocation(topPanelHeight);

                // Readjusts the wdith of the screen
                int newWidth = screen.getWidth();

                // Makes sure that the sidebar stays the way that it's toggled
                if (sideBarVisible) {

                    int firstPaneWidth = (int) (newWidth * 0.7);
                    secondPane.setDividerLocation(firstPaneWidth);

                }
                else {

                    secondPane.setDividerLocation(newWidth);

                }
                
                // Readjusts the toggle button size
                int buttonHeight = (int) (inputPanel.getHeight() * 0.25);
                int buttonWidth = (int) (inputPanel.getWidth() * 0.4);
                toggleButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

            }
        });

        /**
         * This is the action listener for the toggle button
         * used to hide and show the sidebar.
         * 
         */
        toggleButton.addActionListener((@SuppressWarnings("unused") ActionEvent e) -> {

            if (sideBarVisible) {
                
                // This makes the sidebar dissapear
                secondPane.setDividerLocation(1.0);
                toggleButton.setText("Show Sidebar");
                
            }
            else {
                
                // This makes the sidebar reappear
                int newWidth = screen.getWidth();
                int firstPaneWidth = (int) (newWidth * 0.7);
                secondPane.setDividerLocation(firstPaneWidth);
                toggleButton.setText("Hide Sidebar");
                
            }
            sideBarVisible = !sideBarVisible;

        });

        // This adds the panels together and then to the screen
        inputPanel.add(toggleButton, BorderLayout.LINE_END);
        screen.add(secondPane, BorderLayout.CENTER);

    }

    /**
     * This method initializes the input panel.
     * 
     */
    private void initializeInput() {

        inputPanel = new JPanel();
        inputPanel.setName("inputPanel");

        border = BorderFactory.createLineBorder(Color.BLUE, 1);
        inputPanel.setBorder(border);
        
    }

    /**
     * This method initializes the output panel.
     * 
     */
    private void initializeOutput() {

        outputPanel = new JPanel();
        outputPanel.setName("outputPanel");

        border = BorderFactory.createLineBorder(Color.BLUE, 1);
        outputPanel.setBorder(border);

    }

    /**
     * This method initializes the sidebar panel.
     * 
     */
    private void initializeSideBar() {

        sideBarPanel = new JPanel();
        sideBarPanel.add(new JLabel("Sidebar Content"));

    }

}
