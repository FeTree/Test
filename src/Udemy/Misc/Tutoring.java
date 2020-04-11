package Udemy.Misc;

import java.util.*;

public class Tutoring {

    public boolean isPalindrome(String s){
        s = s.toLowerCase();
        String reverse = "";
        for (int i = s.length()-1; i >= 0; i--) {
            reverse+=s.charAt(i);
        }
        if(s.equals(reverse)){
            return true;
        }
        return false;
    }
    public void reverseString(char[] s) {
        String reversed = "";
        for(int i = s.length - 1; i>=0; i--){
            reversed += s[i];
        }
        //System.out.print(reversed);
        char[] arr = reversed.toCharArray();
        System.out.printf("[");
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("\"%s\", ", arr[i]);
        }
        System.out.printf("]");
    }
    public static void main(String[] args) {
        Tutoring app = new Tutoring();
        char[] test = {'a','b', 'c'};
        app.reverseString(test);
        String s = "hi";
    }
}