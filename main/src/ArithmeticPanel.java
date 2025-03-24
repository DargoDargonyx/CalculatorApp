package src;
import javax.swing.JPanel;

/**
 * FrameArithmetic.java
 * Calculator Framework
 * 
 * @author Dargo Dargonyx
 * @author Tencianity
 * @version 03.24.25
 */

public class ArithmeticPanel {
    private  static String NAME = "Arithmetic Calculator";

    private JPanel mainPanel;

    public ArithmeticPanel() {

        createMainPanel();
        initializeButtons();

    }

    public JPanel getPanel()
    {
        return mainPanel;
    }

    private void createMainPanel() {

        mainPanel = new JPanel();
        mainPanel.setName("Arithmetic Panel");

    }

    private void initializeSubPanels() {

        

    }

    private void initializeButtons() {

    }

}
