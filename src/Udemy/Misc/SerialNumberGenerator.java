package Udemy.Misc;

public class SerialNumberGenerator {
    public static void main(String args[]) {
        int quantity = 8;
        int startingNumber = 3038;
        String serialPrefix = "LX";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < quantity; i++){
            sb.append(serialPrefix + startingNumber++ + ", ");
        }
        String result = sb.toString();
        System.out.println(result);
    }
}
