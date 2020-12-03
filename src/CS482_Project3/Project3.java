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

        Object[] bothArrs = app.readFile(path);
        int[] firstHalf = (int[]) bothArrs[0];
        int[] secondHalf = (int[]) bothArrs[1];

        // Call median
        System.out.println(app.findMedianSortedArrays(firstHalf, secondHalf, 0, firstHalf.length-1, 0, secondHalf.length-1));

        // Call Inversions
    }

    private double findMedian(int[] array, int startIndex, int endIndex) {
        int indexDiff = (endIndex - startIndex);
        if (indexDiff % 2 == 0) // we are looking at odd number of elements
        {
            return array[startIndex + (indexDiff/2)];
        }
        else
        {
            return (array[startIndex + (indexDiff/2)] + array[startIndex + (indexDiff/2) + 1])/2;
        }
    }

    public double findMedianSortedArrays(int[] firstHalf, int[] secondHalf, int firstHalfStart, int endOfFirstHalf, int secondHalfStart, int endOfSecondHalf) {
        // Each subarray has 2 elements return median
        if ((endOfFirstHalf - firstHalfStart == 1) && ((endOfSecondHalf - secondHalfStart == 1))) {
            return 1.0 * ((max(firstHalf[firstHalfStart], secondHalf[secondHalfStart]) + min(firstHalf[endOfFirstHalf], secondHalf[endOfSecondHalf])))/2;
        }

        double m1 = findMedian(firstHalf, firstHalfStart, endOfFirstHalf);
        double m2 = findMedian(secondHalf, secondHalfStart, endOfSecondHalf);

        // equivalent medians
        if (m2 == m1) {
            return m2;
        }


        // Cross out elements less than first median and greater than second median
        if (m1 < m2) {
            if ((endOfFirstHalf - firstHalfStart) % 2 == 0){
                firstHalfStart = firstHalfStart + (endOfFirstHalf - firstHalfStart) / 2;
                endOfSecondHalf = secondHalfStart + (endOfSecondHalf - secondHalfStart) / 2;
            }
            else { // even elemements
                firstHalfStart = firstHalfStart + (endOfFirstHalf - firstHalfStart) / 2;
                endOfSecondHalf = secondHalfStart + (endOfSecondHalf - secondHalfStart) / 2 + 1;
            }
        }
        // Cross out elements less than second median and anything greater than first median
        else // m2 < m1
        {
            if ((endOfSecondHalf - secondHalfStart) % 2 == 0) {
                secondHalfStart = secondHalfStart + (endOfSecondHalf - secondHalfStart) / 2;
                endOfFirstHalf = firstHalfStart + (endOfFirstHalf - firstHalfStart) / 2;
            }
            else { // even
                secondHalfStart = secondHalfStart + (endOfSecondHalf - secondHalfStart) / 2;
                endOfFirstHalf = firstHalfStart + (endOfFirstHalf - firstHalfStart) / 2 + 1;
            }
        }
        return findMedianSortedArrays(firstHalf, secondHalf, firstHalfStart, endOfFirstHalf, secondHalfStart, endOfSecondHalf);
    }

    public Object[] readFile(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        int size = scanner.nextInt();
        int[] firstHalf = new int[size];
        int[] secondHalf = new int[size];

        for (int i = 0; i < size; i++) {
            firstHalf[i] = scanner.nextInt();
        }
        for (int i = 0; i < size; i++) {
            secondHalf[i] = scanner.nextInt();
        }
        return new Object[]{firstHalf, secondHalf};
    }

}
