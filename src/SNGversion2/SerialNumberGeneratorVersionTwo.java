package SNGversion2;

/*
Author: David Eisenbaum
 */

//imports
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.*;

public class SerialNumberGeneratorVersionTwo {

    //global variables
    int quantity;
    int startingNumber;
    String serialPrefix;
    String result;
    StringBuilder sb;
    Toolkit tk;
    Clipboard clipboard;
    StringSelection strSel;

    //constructor
    public SerialNumberGeneratorVersionTwo(){
        quantity = 0;
        startingNumber = 0;
        serialPrefix = "";
        sb = new StringBuilder();
        tk = Toolkit.getDefaultToolkit();
        clipboard = tk.getSystemClipboard();
    }

    //generate the serial numbers
    public String generate(){
        //TODO: The last serial number has a comma after it, that last comma should not be there
        for(int i = 0; i < (quantity); i++){
            sb.append(serialPrefix + startingNumber++ + ", ");
        }
        result = sb.toString();

        //copy to clipboard for easy ctrl + v
        strSel = new StringSelection(result);
        clipboard.setContents(strSel, null);

        return result;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStartingNumber() {
        return startingNumber;
    }

    public void setStartingNumber(int startingNumber) {
        this.startingNumber = startingNumber;
    }

    public String getSerialPrefix() {
        return serialPrefix;
    }

    public void setSerialPrefix(String serialPrefix) {
        this.serialPrefix = serialPrefix;
    }
}
