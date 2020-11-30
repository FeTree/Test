package CS482_Project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Project3 {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\David Eisenbaum\\IdeaProjects\\Test\\src\\CS482_Project3\\input3.txt";


        Project3 app = new Project3();
        ArrayList<Integer> allNums = app.readFile(path);
        allNums.remove(0);
        System.out.println(allNums);



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

        System.out.println(app.findMedianSortedArrays(firstHalf, secondHalf, 0, firstHalf.length - 1, 0, secondHalf.length-1));
        System.out.println(app.mergeSort(allNumsArray, 0, allNumsArray.length-1));

    }

    public double findMedian(int[] nums) {
        if (nums.length % 2 == 0)
            return ((double)nums[nums.length/2] + (double)nums[nums.length/2 - 1])/2;
        else
            return (double) nums[nums.length/2];
    }

    public double findMedianSortedArrays(int[] a, int[] b, int startIndexA, int endIndexA, int startIndexB, int endIndexB)
    {


        if ((endIndexA - startIndexA == 0) && ((endIndexB - startIndexB == 0)))
        {
            return (a[0] + b[0])/2;
        }

        if ((endIndexA - startIndexA == 1) && ((endIndexB - startIndexB == 1)))
        {
            return (1.0*(max(a[startIndexA], b[startIndexB]) + min(a[endIndexA], b[endIndexB])))/2;
        }

        double m1 = findMedian(a);
        double m2 = findMedian(b);

        if (m2 == m1)
        {
            return m2;
        }

        // first half median less than second half median, cross out anything less than first half median and anythibng greater than median of second half
        if (m1 < m2)
        {
            if ((endIndexA - startIndexA) % 2 == 0) // we are looking at odd number of elements
            {
                startIndexA = startIndexA + (endIndexA - startIndexA) / 2;
                endIndexB = startIndexB + (endIndexB - startIndexB) / 2;
            }
            else
            {
                startIndexA = startIndexA + (endIndexA - startIndexA) / 2;
                endIndexB = startIndexB + (endIndexB - startIndexB) / 2 + 1;
            }
        }

        // since m2 <= median <= m1 narrow down search by eliminating elements less than m2 and elements greater than m1
        else // m2 < m1
        {
            if ((endIndexB - startIndexB) % 2 == 0) // we are looking at odd number of elements
            {
                startIndexB = startIndexB + (endIndexB - startIndexB) / 2;
                endIndexA = startIndexA + (endIndexA - startIndexA) / 2;
            }
            else
            {
                startIndexB = startIndexB + (endIndexB - startIndexB) / 2;
                endIndexA = startIndexA + (endIndexA - startIndexA) / 2 + 1;
            }
        }
        return findMedianSortedArrays(a, b, startIndexA, endIndexA, startIndexB, endIndexB);
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

    public int countInversions(int[] arr, int l, int m, int r) {

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

    public int mergeSort(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int m = (left + right) / 2;

            // Left Array
            count += mergeSort(arr, left, m);

            // Right Array
            count += mergeSort(arr, m + 1, right);

            // count merge
            count += countInversions(arr, left, m, right);
        }
        return count;
    }
}
