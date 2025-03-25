package src;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
    private ArithmeticPanel arithmeticScreen;
    private JPanel conversionPanel;

    /**
     * This is the no argument constructor for the class that
     * will create the main frame, then add the panels to the
     * frame, and then making everything visible.
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
     * from different the seperate calculator classes.
     * 
     */
    @SuppressWarnings("static-access")
    public void createFrame() {

        mainFrame = new JFrame(NAME);
        mainFrame.setName(NAME);
        mainFrame.setLayout(new GridBagLayout());

        mainFrame.setLocation(0,0);
        mainFrame.setSize(screensize);

        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);

    }

    /**
     * Adds all required panels to the main frame, starting on the
     * arithmentic screen.
     * 
     */
    public void appendPanelsToFrame(GridBagConstraints gbc) {

        arithmeticScreen = new ArithmeticPanel();
        arithmeticScreen.getPanel().setLayout(new GridBagLayout());
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainFrame.add(arithmeticScreen.getPanel(), gbc);


        // fuck me.
        ConversionPanel conversionScreen = new ConversionPanel();
        conversionPanel = conversionScreen.getMainPanel();
        conversionPanel.setLayout(new GridBagLayout());
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainFrame.add(conversionPanel, gbc);

    }

    /**
     * This method sets the main frame and everything inside visible
     * 
     */
    public void displayFrame() {
        
        mainFrame.setVisible(true);

    }
}