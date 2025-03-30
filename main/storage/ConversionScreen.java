package storage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
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
    private JSplitPane totalPane;
    private JSplitPane leftPane;
    private JSplitPane rightPane;
    private JPanel buttonPanel;
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
        initializeInputOutput();
        initializeSideBar();
        
        // Makes a total pane from combining the previous panes
        totalPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPane, rightPane);
        totalPane.setResizeWeight(0.7);
        totalPane.setDividerLocation(0.7);
        totalPane.setDividerSize(1);
        totalPane.setEnabled(false);

        screen.add(totalPane, BorderLayout.CENTER);

    }

    /**
     * This method initializes the input panel.
     * 
     */
    private void initializeInputOutput() {

        inputPanel = new JPanel();
        inputPanel.setBackground(new Color(211, 211, 211));

        outputPanel = new JPanel();
        outputPanel.setBackground(new Color(169, 169, 169));

        leftPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, inputPanel, outputPanel);
        leftPane.setResizeWeight(0.7);
        leftPane.setDividerLocation(0.7);
        leftPane.setDividerSize(0);
        leftPane.setEnabled(false);
        
    }

    /**
     * This method initializes the sidebar panel.
     * 
     */
    private void initializeSideBar() {

        JPanel sideBarPanel = new JPanel();
        sideBarPanel.add(new JLabel("Sidebar Content"));
        sideBarPanel.setBackground(new Color(140, 140, 140));

        buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(new Color(0, 0, 0));
        JButton toggleButton = new JButton(">");
        buttonPanel.add(toggleButton, BorderLayout.CENTER);

        rightPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonPanel, sideBarPanel);
        rightPane.setDividerLocation(0.15);
        rightPane.setDividerSize(0);
        rightPane.setEnabled(false);
        sideBarVisible = true;

        /**
        * This is the action listener for the toggle button
        * used to hide and show the sidebar.
        * 
        */
        toggleButton.addActionListener((@SuppressWarnings("unused") ActionEvent e) -> {

            if (sideBarVisible) {
                
                // This makes the sidebar dissapear
                totalPane.setDividerLocation(totalPane.getWidth() - buttonPanel.getWidth());
                rightPane.setDividerLocation(rightPane.getWidth());
                toggleButton.setText("<");
                
            }
            else {
                
                // This makes the sidebar appear
                totalPane.setDividerLocation(0.7);
                int newWidth = (int) (rightPane.getWidth() * 0.15);
                rightPane.setDividerLocation(newWidth);
                toggleButton.setText(">");
                
            }
            sideBarVisible = !sideBarVisible;

        });

    }

}
