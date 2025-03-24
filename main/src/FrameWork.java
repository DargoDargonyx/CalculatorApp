package src;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

import ArithmeticPanel;

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
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screensize = toolkit.getScreenSize();

    private static String NAME = "Calculator";
    // Main frame
    private JFrame frame;

    public FrameWork() {

        createFrame();
        appendPanelsToFrame();
        displayFrame();

    }

    /**
     * Create the main frame out of panels pulled from different calculator classes.
     */
    @SuppressWarnings("static-access")
    public void createFrame() {

        frame.setName(NAME);
        frame.setTitle(NAME);
        frame.setLocation(0,0);
        frame.setSize(screensize);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

    }

    /**
     * Adds all required panels to the main frame, starting on the arithmentic screen.
     */
    public void appendPanelsToFrame() {

        ArithmeticPanel arithmeticScreen = new ArithmeticPanel();
        frame.add(arithmeticScreen.getPanel());

    }

    public void displayFrame() 
    {frame.setVisible(true);}
}