package Udemy.Misc;

import java.util.*;
public class VAI {
    //welcome to AI of voldemort


    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Arianna: Hey David what is up");
        boolean flag = true;
        ArrayList<String> bugs = new ArrayList<>();
        while(flag){
            String input = keyboard.nextLine();
            if(input.contains("bye")){
                System.out.println("Bye babe I wanna fuck u so bad");
                flag = false;
            }
            else if(input.contains("fuck")){
                System.out.println("Arianna: Yes of course I want to fuck you david");
            }
            else if(input.contains("dick")){
                System.out.println("Arianna: Your dick is tiny");
            }
            else if(input.contains("muscle")){
                System.out.println("Arianna: yes youre fucking yoked david");
            }
            else if(input.contains("up")){
                System.out.println("Arianna: nothing much");
            }
            else if(input.contains("mean")){
                System.out.println("Arianna: Youre an asshole");
            }
            else if(input.contains("fight")){
                System.out.println("Arianna: I dont wanna talk about this right now");
            }
            else if(input.contains("hi")){
                System.out.println("Arianna: Hi baby");
            }
            else if(input.contains("bitch")){
                System.out.println("Arianna: ur so mean");
            }
            else if(input.contains("overwatch")){
                System.out.println("Arianna: yes of course i wanna play with you");
            }
            else{
                bugs.add(input);
                System.out.println("What did you say?");
            }
        }
    }
}

