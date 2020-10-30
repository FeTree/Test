/*
Author: David Eisenbaum
Date: 10/09/2020
 */
package CS482;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Project1 {
    //Globals
    String pathToFile = "C:\\Users\\David Eisenbaum\\IdeaProjects\\Test\\src\\CS482\\input1.txt";
    ArrayList<Integer> listAllNumbers = new ArrayList<>();
    ArrayList<Integer> listBeforeZero = new ArrayList<>();
    ArrayList<Integer> listAfterZero = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        int[] arr = {119, 9, -2, 57, 29, 73, 93};
        int target = 249;

        Project1 app = new Project1();
        app.readFile(app.pathToFile);
        app.separateList(app.listAllNumbers);


        int[] arrayBeforeZero = app.convertArrayListToArray(app.listBeforeZero);
        Arrays.sort(arrayBeforeZero); //nlogn

        // Run the algorithm with input from the text file
        for (int i = 0; i < app.listAfterZero.size(); i++) {
           if(app.threeSum(arrayBeforeZero, app.listAfterZero.get(i))) {
               System.out.println(app.listAfterZero.get(i) + " YES");
           }
           else {
               System.out.println(app.listAfterZero.get(i) + " NO");
           }
        }
    }

    /*
    Function reads integers from text file and stores in an ArrayList
     */
    public void readFile(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        while(scanner.hasNextInt()) {
            listAllNumbers.add(scanner.nextInt());
        }
    }

    /*
    Separates list before and after the zero
     */
    public void separateList(ArrayList<Integer> list) {
        int i;
        for (i = 0; i < list.size(); i++) {
            if(list.get(i) == 0) {
                break;
            }
            listBeforeZero.add(list.get(i));
        }
        for (int j = i+1; j < list.size(); j++) {
            listAfterZero.add(list.get(j));
        }
    }

    /*
    Prints numbers in an arraylist
     */
    public void printArrayList(ArrayList<Integer> list) {
        for (int i: list) {
            System.out.println(i);
        }
    }

    /*
    Convert arraylist to array
     */
    public int[] convertArrayListToArray(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


    /*
    Algorithm to find three sums that add up to a target value
     */
    public boolean threeSum(int nums[], int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i;
            int right = nums.length - 1;

            while (left < right) {
                if(target == nums[i] + nums[left] + nums[right]) {
                    return true;
                }
                else if (nums[i] + nums[left] + nums[right] < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return false;
    }
}
