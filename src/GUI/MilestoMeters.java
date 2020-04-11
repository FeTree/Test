package GUI;

/*
Name: David Eisenbaum
Date: 04/27/2016
Program Name: GUI2
Purpose: To learn how to use GUI imports from java
*/
import java.util.Scanner;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

class MilestoMeters extends JInternalFrame
{
    private static MilestoMeters instance = null;

    private JTextField tf;
    private JButton btn;
    private JLabel lbl, lbl2;
    private JPanel upperPanel, lowerPanel;

    public static MilestoMeters getInstance() {
        if(instance == null) {
            instance = new MilestoMeters();
        }
        return instance;
    }

    double input = 0;
    public void milesToMet(){
        try {
            input = Double.parseDouble(tf.getText());

            lbl2.setText("Enter Miles: ");
            input = Double.parseDouble(tf.getText());

            double answer = input * 1609.344;
            //rounding
            double mathRound = Math.round(answer * 10d) / 10d;

            lbl2.setText("Meters " + mathRound);


        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Bad input! Try again.");
        }
    }

    // private constructor
    private MilestoMeters() {

        // call constructor of JInternalFrame
        // Arguments: title, resizability, closability,
        //               maximizability, and iconifiability
        super("Miles to Meters", false, true, false, false);

        tf = new JTextField(10);
        btn = new JButton("Convert");
        lbl = new JLabel("Answer: ");
        lbl2 = new JLabel();
        upperPanel = new JPanel();
        lowerPanel = new JPanel();

        upperPanel.setLayout(new FlowLayout());
        upperPanel.setLayout(new FlowLayout());

        upperPanel.add(tf);
        upperPanel.add(btn);

        lowerPanel.add(lbl);
        lowerPanel.add(lbl2);

        add(upperPanel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.SOUTH);
        // add button listener
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                milesToMet();
            }
        });

        setBounds(25, 25, 250, 120);
        setLocation(100, 100);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    } // end private constructor



}
