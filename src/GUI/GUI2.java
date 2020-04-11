package GUI;

/*
Name: David Eisenbaum
Date: 04/27/2016
Program Name: GUI2
Purpose: To learn how to use GUI imports from java
*/
// abstract window toolkit (awt)
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Cursor;
// awt events
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// swing
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JButton;
// swing event
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
// swing tree
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class GUI2
{

    //member variables
    private JFrame frame;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JDesktopPane desktop;
    private JSplitPane splitPane;
    private JPanel labelPanel;
    private JLabel statusLabel;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu helpMenu;
    private JMenuItem exitItem;
    private JMenuItem aboutItem;
    private JTree tree;

    public GUI2()
    {
        initComponents();
        statusLabel.setText("Initialization complete.");
    }

    private void initComponents() {
        setLookAndFeel();
        buildDesktop();
        buildTree();
        addTreeListeners();
        buildMenu();
        addMenuListeners();
        buildPanel();
        buildFrame();
    }

    private void setLookAndFeel() {

        try {

            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

        }
        catch (Exception e) {

            e.printStackTrace();

        }

    }
    private void buildDesktop() {

        desktop = new JDesktopPane()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                ImageIcon icon = new ImageIcon("C:/Users/dvdei/Desktop/Random Java Programs/logos/TE6S4S4SL5FURHVU4A4EKJG5B4.jpg");
                Image image = icon.getImage();
                frame.setIconImage(image);

                ImageIcon imageInMiddle = new ImageIcon("C:/Users/dvdei/Desktop/Random Java Programs/logos/engineering.png");
                Image imageTwo = imageInMiddle.getImage();

                int x=0, y=0;
                double imageWidth = image.getWidth(null);
                double imageHeight = image.getHeight(null);
                double screenWidth = getWidth();
                double screenHeight = getHeight();

                if(screenWidth != 0) {
                    x = (int)screenWidth  / 2 - (int)imageWidth  / 2;
                }

                if(screenHeight != 0) {
                    y = (int)screenHeight / 2 - (int)imageHeight / 2;
                }

                //g.drawImage(image, x, y, this); //display in middle of screen
            }
        };

    } // end buildDesktop

    private void buildMenu() {

        // build menu
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");
        exitItem = new JMenuItem("Exit");
        aboutItem = new JMenuItem("About");
        fileMenu.add(exitItem);
        helpMenu.add(aboutItem);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

    } // end buildMenu


    public void exitActionPerformed() {
        frame.dispose();
    }

    public void aboutActionPerformed() {
        JOptionPane.showMessageDialog(null, "Thanks for using my app!");
    }

    private void addMenuListeners() {

        // add listener for exit menu item
        exitItem.addActionListener(
                new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        exitActionPerformed();
                    }
                }
        );

        // add listener for about menu item
        aboutItem.addActionListener(
                new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        aboutActionPerformed();
                    }
                }
        );

    } // end addMenuListeners
    private void buildPanel() {

        panel = new JPanel();
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        scrollPane = new JScrollPane();
        labelPanel = new JPanel();
        statusLabel = new JLabel();


        scrollPane.getViewport().add(tree);

        statusLabel.setBorder(BorderFactory.createLoweredBevelBorder());
        statusLabel.setMinimumSize(new Dimension(0,18));
        statusLabel.setPreferredSize(new Dimension(0,18));

        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(200);
        splitPane.setContinuousLayout(true);
        splitPane.add(desktop, JSplitPane.RIGHT);
        splitPane.add(scrollPane, JSplitPane.LEFT);

        panel.setLayout(new BorderLayout());
        panel.add(splitPane, BorderLayout.CENTER);

        labelPanel.setLayout(new BorderLayout());
        labelPanel.add(statusLabel, BorderLayout.CENTER);

    } // end buildPanel
    private void buildFrame() {

        // create a new frame and show it
        frame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("My GUI Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:/Comp110Labs/csun.gif"));
        // add label panel
        frame.getContentPane().add(labelPanel, BorderLayout.SOUTH);
        // add main panel
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        // add menu bar
        frame.setJMenuBar(menuBar);
        frame.setSize(1280,800);
        frame.setVisible(true);

    }

    private void buildTree() {

        // Create data for the tree
        DefaultMutableTreeNode root
                = new DefaultMutableTreeNode("Tools");

        DefaultMutableTreeNode alg
                = new DefaultMutableTreeNode("Algorithms");

        //algos

        DefaultMutableTreeNode odd
                = new DefaultMutableTreeNode("Check for an odd Number");

        DefaultMutableTreeNode moonWeight
                = new DefaultMutableTreeNode("Calculate your weight on the moon");

        DefaultMutableTreeNode milestoMeters
                = new DefaultMutableTreeNode("Convert Miles to Meters");

        DefaultMutableTreeNode milestoKM
                = new DefaultMutableTreeNode("Convert Miles to Kilometers");

        DefaultMutableTreeNode phoneGen
                = new DefaultMutableTreeNode("Generate a Phone Number");

        DefaultMutableTreeNode decHex
                = new DefaultMutableTreeNode("Convert Decimal to Hex-Dec");

        DefaultMutableTreeNode dectoBIN
                = new DefaultMutableTreeNode("Convert Decimal to Binary");

        DefaultMutableTreeNode passwordG
                = new DefaultMutableTreeNode("Generate a Password");


        //fileinfo
        DefaultMutableTreeNode io
                = new DefaultMutableTreeNode("IO");
        DefaultMutableTreeNode fileInfo
                = new DefaultMutableTreeNode("File Info");

        alg.add(odd);
        alg.add(moonWeight);
        alg.add(milestoMeters);
        alg.add(milestoKM);
        alg.add(phoneGen);
        alg.add(decHex);
        alg.add(dectoBIN);
        alg.add(passwordG);
        io.add(fileInfo);
        root.add(alg);
        root.add(io);
        // create a new tree
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);
    } // end of buildTree
    private void addTreeListeners() {

        tree.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        int selRow = tree.getRowForLocation(e.getX(), e.getY());
                        if(selRow != -1) {
                            treeClicked();
                        }
                    }
                }
        );

    } // end of addTreeListeners

    private void treeClicked() {
        // get the last selected tree node
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                tree.getLastSelectedPathComponent();

        // if the node is a leaf (no children, keep going)
        if (node != null && node.isLeaf()) {

            statusLabel.setText(node.toString() + " clicked.");

            if(node.toString().equals("Check for an odd Number")) {
                OddDialog od = OddDialog.getInstance();
                if(!od.isVisible()) {
                    od.setVisible(true);
                    desktop.add(od);
                }
            }

            if(node.toString().equals("Calculate your weight on the moon")) {
                WeightOnMoon lbonMOon = WeightOnMoon.getInstance();
                if(!lbonMOon.isVisible()) {
                    lbonMOon.setVisible(true);
                    desktop.add(lbonMOon);
                }
            }

            if(node.toString().equals("Convert Miles to Meters")) {
                MilestoMeters milestoME = MilestoMeters.getInstance();
                if(!milestoME.isVisible()) {
                    milestoME.setVisible(true);
                    desktop.add(milestoME);
                }
            }
            if(node.toString().equals("Convert Miles to Kilometers")) {
                MilesToKilometers milestoKmers = MilesToKilometers.getInstance();
                if(!milestoKmers.isVisible()) {
                    milestoKmers.setVisible(true);
                    desktop.add(milestoKmers);
                }
            }
            if(node.toString().equals("Generate a Phone Number")) {
                PhoneGenerator phoneG = PhoneGenerator.getInstance();
                if(!phoneG.isVisible()) {
                    phoneG.setVisible(true);
                    desktop.add(phoneG);
                }
            }

            if(node.toString().equals("Convert Decimal to Hex-Dec")) {
                DecimaltoHex dectohexD = DecimaltoHex.getInstance();
                if(!dectohexD.isVisible()) {
                    dectohexD.setVisible(true);
                    desktop.add(dectohexD);
                }
            }
            if(node.toString().equals("Convert Decimal to Binary")) {
                BinaryConversion binaryC =  BinaryConversion.getInstance();
                if(!binaryC .isVisible()) {
                    binaryC .setVisible(true);
                    desktop.add(binaryC );
                }
            }
            if(node.toString().equals("Generate a Password")) {
                PasswordGenerator passG = PasswordGenerator.getInstance();
                if(!passG.isVisible()) {
                    passG.setVisible(true);
                    desktop.add(passG);
                }
            }
            else if(node.toString().equals("File Info")) {
                ReadDialog readD = ReadDialog.getInstance();
                if(!readD.isVisible()) {
                    readD.setVisible(true);
                    desktop.add(readD);
                }
            }

        }
    }
}
