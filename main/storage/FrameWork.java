package storage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 * This class is meant to provide the JFrames in the calculator app
 * that will be built. This includes any tabs needed for the GUI as
 * well as controlling the placement of buttons and such.
 * 
 * @author DargoDargonyx
 * @author Tencianity
 * @version 3.24.2025
 * 
 */
public class FrameWork {

    // Get the user's screen size and save it as a Dimension object
    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final Dimension screensize = toolkit.getScreenSize();

    private JFrame mainFrame; // Main frame
    private static final String NAME = "Calculator";

    /**
     * This is the no argument constructor for the class that
     * will create the main frame, then add the panels to the
     * frame, then make everything visible.
     * 
     */
    public FrameWork() {

        GridBagConstraints gbc = new GridBagConstraints(); // Used to edit the layout of the panels
        createFrame();
        appendPanelsToFrame(gbc);
        displayFrame();

    }

    /**
     * This method creates the main frame out of panels pulled 
     * from the seperate calculator classes.
     * 
     */
    @SuppressWarnings("static-access")
    public void createFrame() {

        mainFrame = new JFrame(NAME);
        mainFrame.setName(NAME);
        mainFrame.setLayout(new BorderLayout());

        mainFrame.setLocation(0,0);
        mainFrame.setSize(screensize);

        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);

    }

    /**
     * Adds all required panels to the main frame using tabs.
     * 
     */
    public void appendPanelsToFrame(GridBagConstraints gbc) {

        ConversionScreen conversionScreen = new ConversionScreen();
        ArithmeticScreen arithmeticScreen = new ArithmeticScreen();
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Arithemtic", arithmeticScreen.getScreen());
        tabbedPane.add("Conversion", conversionScreen.getScreen());
        mainFrame.add(tabbedPane, BorderLayout.CENTER);

    }

    /**
     * This method sets the main frame and everything inside visible
     * 
     */
    public void displayFrame() {
        
        mainFrame.setVisible(true);
        mainFrame.pack();

    }
}