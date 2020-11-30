package CS482_Project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Project3 {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\David Eisenbaum\\IdeaProjects\\Test\\src\\CS482_Project3\\input3.txt";


        Project3 app = new Project3();
        ArrayList<Integer> allNums = app.readFile(path);
        allNums.remove(0);



        Object[] testO = (new ArrayList<>(allNums.subList(0, allNums.size()))).toArray();
        Integer[] testI = Arrays.copyOf(testO, testO.length, Integer[].class);
        int[] allNumsArray = app.toIntArray(testI);


        // First half of array
        Object[] firstHalfOBJ = (new ArrayList<>(allNums.subList(0, allNums.size()/2))).toArray();
        Integer[] firstHalfI = Arrays.copyOf(firstHalfOBJ, firstHalfOBJ.length, Integer[].class);
        int[] firstHalf = app.toIntArray(firstHalfI);

        // Second half of array
        Object[] secondHalfOBJ = (new ArrayList<>(allNums.subList(allNums.size()/2, allNums.size()))).toArray();
        Integer[] secondHalfI = Arrays.copyOf(secondHalfOBJ, secondHalfOBJ.length, Integer[].class);
        int[] secondHalf = app.toIntArray(secondHalfI);

        System.out.println(app.mergeSortAndCount(allNumsArray, 0, allNumsArray.length-1));

    }


    // Read input file
    public ArrayList<Integer> readFile(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        ArrayList<Integer> allNums = new ArrayList<>();
        while(scanner.hasNextInt()) {
            allNums.add(scanner.nextInt());
        }
        return allNums;
    }

    int[] toIntArray(Integer[] list){
        int[] ret = new int[list.length];
        for(int i = 0;i < ret.length;i++)
            ret[i] = list[i];
        return ret;
    }

    public int mergeAndCount(int[] arr, int l, int m, int r) {

        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0;
        int j = 0;
        int k = l;
        int numOfSwaps = 0;

        while (i < left.length && j < right.length)
        {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                numOfSwaps += (m + 1) - (l + i);
            }
        }
        return numOfSwaps;
    }

    public int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int m = (left + right) / 2;

            // Left Array
            count += mergeSortAndCount(arr, left, m);

            // Right Array
            count += mergeSortAndCount(arr, m + 1, right);

            // count merge
            count += mergeAndCount(arr, left, m, right);
        }
        return count;
    }
}
