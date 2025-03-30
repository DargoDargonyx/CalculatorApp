package storage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

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

    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final Dimension screensize = toolkit.getScreenSize();
    private JFrame mainFrame; // Main frame
    private static final String NAME = "CalculatorApp";

    /**
     * This is the no argument constructor for the class that
     * will create the main frame, then add the panels to the
     * frame, then make everything visible.
     * 
     */
    public FrameWork() {

        createFrame();
        appendPanelsToFrame();
        displayFrame();

    }

    /**
     * This method creates the main frame out of panels pulled 
     * from the seperate calculator classes.
     * 
     */
    @SuppressWarnings("static-access")
    public void createFrame() {

        UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));

        mainFrame = new JFrame(NAME);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setResizable(false);
        mainFrame.setUndecorated(true);

        JPanel titleBar = new JPanel();
        titleBar.setBackground(new Color(0, 0, 139));
        titleBar.setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel(NAME);
        titleLabel.setForeground(Color.WHITE);
        titleBar.add(titleLabel);
        titleBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JPanel exitPanel = new JPanel(new BorderLayout());
        JButton closeButton = new JButton("X");
        exitPanel.add(closeButton, BorderLayout.CENTER);
        closeButton.addActionListener(e -> System.exit(0));
        
        final Point initialClick = new Point();
        titleBar.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                initialClick.setLocation(e.getPoint());

            }

        });
        titleBar.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {

                int xDisplacement = e.getX() - initialClick.x;
                int yDisplacement = e.getY() - initialClick.y;
                Point p = mainFrame.getLocation();
                mainFrame.setLocation(p.x + xDisplacement, p.y + yDisplacement);

            }
        });


        JPanel contentPanel = new JPanel();
        JSplitPane topBarPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, titleBar, exitPanel);
        topBarPane.setResizeWeight(0.95);
        topBarPane.setDividerLocation(0.95);
        topBarPane.setDividerSize(0);
        topBarPane.setBorder(BorderFactory.createEmptyBorder());

        mainFrame.getContentPane().add(topBarPane, BorderLayout.NORTH);
        mainFrame.getContentPane().add(contentPanel, BorderLayout.CENTER);
        mainFrame.getContentPane().setBackground(Color.BLACK);

        mainFrame.setLocation(0,0);
        mainFrame.setSize(600, 400);
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);

    }

    /**
     * Adds all required panels to the main frame using tabs.
     * 
     */
    public void appendPanelsToFrame() {

        ConversionScreen conversionScreen = new ConversionScreen();
        ArithmeticScreen arithmeticScreen = new ArithmeticScreen();
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Arithemtic", arithmeticScreen.getScreen());
        tabbedPane.add("Conversion", conversionScreen.getScreen());

        mainFrame.add(tabbedPane, BorderLayout.CENTER);

        tabbedPane.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {

                int selectedIndex = tabbedPane.getSelectedIndex();
                switch (selectedIndex) {

                    case 0:
                        break;
                    case 1:
                        mainFrame.setSize(700, 400);
                        break;
                    default:
                        throw new AssertionError("No such tab exists.");

                }
            }
        });

    }

    /**
     * This method sets the main frame and everything inside visible
     * 
     */
    public void displayFrame() {
        
        mainFrame.setVisible(true);

    }
}