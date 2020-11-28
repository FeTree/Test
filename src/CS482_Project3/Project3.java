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

        System.out.println(allNums.size()/2);
        Collections.sort(allNums);
        System.out.println(allNums);


        Object[] testO = (new ArrayList<>(allNums.subList(0, allNums.size()))).toArray();
        Integer[] testI = Arrays.copyOf(testO, testO.length, Integer[].class);
        int[] test = app.toIntArray(testI);


        // First half of array
        Object[] firstHalfOBJ = (new ArrayList<>(allNums.subList(0, allNums.size()/2))).toArray();
        Integer[] firstHalf = Arrays.copyOf(firstHalfOBJ, firstHalfOBJ.length, Integer[].class);

        // Second half of array
        Object[] secondHalfOBJ = (new ArrayList<>(allNums.subList(allNums.size()/2, allNums.size()))).toArray();
        Integer[] secondHalf = Arrays.copyOf(secondHalfOBJ, secondHalfOBJ.length, Integer[].class);

        double median = findMedian(test, test.length);
        System.out.println(median);

    }

    public static double findMean(int a[], int n)
    {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += a[i];

        return (double)sum / (double)n;
    }

    // Function for calculating median
    public static double findMedian(int a[], int n)
    {
        // First we sort the array
        Arrays.sort(a);

        // check for even case
        if (n % 2 != 0)
            return (double)a[n / 2];

        return (double)(a[(n - 1) / 2] + a[n / 2]) / 2.0;
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
}
