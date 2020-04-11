package SNGversion2;

import Udemy.Misc.SerialNumberGenerator;

import javax.swing.*;
public class GuiApp1{
    SerialNumberGeneratorVersionTwo sng;

    public GuiApp1(){

        sng = new SerialNumberGeneratorVersionTwo();

        JTextField quantity2 = new JTextField(5);
        sng.setQuantity(Integer.parseInt(quantity2.getText()));

        JTextField startingNumber2 = new JTextField(5);
        sng.setStartingNumber(Integer.parseInt(startingNumber2.getText()));

        JTextField serialPrefix2 = new JTextField(5);
        sng.setSerialPrefix(serialPrefix2.getText());


        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Quantity:"));
        myPanel.add(quantity2);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("First Serial Number:"));
        myPanel.add(startingNumber2);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Serial Prefix:"));
        myPanel.add(serialPrefix2);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter quantity, the first serial number, and the serial prefix. ", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println("Quantity: " + Integer.parseInt(quantity2.getText()));
            System.out.println("Starting value: " + Integer.parseInt(startingNumber2.getText()));
            System.out.println("Serial Prefix: " + serialPrefix2.getText());
            JOptionPane.showConfirmDialog(null, sng.result);
        }
    }
    public static void main(String[] args) {
        GuiApp1 gui = new GuiApp1();
    }
}
