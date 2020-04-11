import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class UrlPlayground {

    public static void main(String[] args) throws Exception {

        URL link = new URL("https://store.steampowered.com/login/");
        BufferedReader in = new BufferedReader(new InputStreamReader(link.openStream()));

        ArrayList<String> inputArray = new ArrayList<>();
        String inputLine;

        // Store source code into arraylist
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            inputArray.add(inputLine);
        }

        // Determine how many times the company name appears in source code
        int count = 0;
        for (int i = 0; i < inputArray.size() ; i++) {
            if (inputArray.get(i).contains("steam")) {
                count = count + 1;
            }
        }

        System.out.println("The company name, Steam, was mentioned: " + count + " times ");

        // close BufferedReader
        in.close();
    }
}
