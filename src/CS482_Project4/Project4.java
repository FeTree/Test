package CS482_Project4;
/*
Author: David Eisenbaum
COMP 482
Professor Noga
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Project4 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\David Eisenbaum\\IdeaProjects\\Test\\src\\CS482_Project4\\input4.txt ";
        Project4 app = new Project4();

        // Read file
        int[][] input = app.readFile(path);
        System.out.println(Arrays.deepToString(input));

        System.out.println(getLongestPath(input));
    }

    public int longestPath(int[][] input) {
        int answer = 1;

        int rows = input[0].length;
        int columns = input.length;
        int[][] opt = new int[rows][columns];

        // Pointer to keep track of largest value in array so we dont have to search it
        int largestValue = 0;

        // Set all values to 1 in opt
        for (int[] row: opt) {
            Arrays.fill(row, 1);
        }


        for (int i = 0; i < rows ; i++) {
            for (int j = 1; j < columns; j++) {
                // Current is less than value to the right
                System.out.println(input[i][j]);
                if(i > 1) {
                    if (input[i - 1][j] > input[i][j]) {
                        opt[i][j] = 1 + opt[i - 1][j];
                        //System.out.println("1st" + opt[i][j]);
                    }

                    //Current is less than value above it, increment by one

                    else if (input[i][j - 1] > input[i][j]) {
                        opt[i][j] = 1 + opt[i][j - 1];
                        //System.out.println("2st" + opt[i][j]);
                    }
                }


                // Check if its largest value
                if(opt[i][j] > largestValue) {
                    largestValue = opt[i][j];
                }
            }
        }

        System.out.println(Arrays.deepToString(opt));



        return largestValue;
    }

    public static int getLongestPath(int[][] input) {
        int largestValue = 0;

        int rows = input.length;
        int cols = input[0].length;

        // Init dp table
        int dp[][] = new int[rows][cols];

        // Fill 2D array with 1
        for (int[] row: dp)
            Arrays.fill(row, 1);

        // Check first row
        for (int row = 1; row < rows; ++row) {
            if (input[row - 1][0] > input[row][0]) {
                dp[row][0] = dp[row - 1][0] + 1;
            }
        }

        // Check first column
        for (int col = 1; col < cols; ++col) {
            if (dp[0][col - 1] > 0 && input[0][col - 1] > input[0][col]) {
                dp[0][col] = dp[0][col - 1] + 1;
            }
        }

        for (int row = 1; row < rows; ++row) {
            for (int col = 1; col < cols; ++col) {
                int left = -1;
                int top = -1;

                // If value on the left is bigger than current pos
                if (input[row - 1][col] > input[row][col]) {
                    left = dp[row - 1][col];
                }

                // If value above is bigger than current pos
                if (input[row][col - 1] > input[row][col]) {
                    top = dp[row][col - 1];
                }

                // Take larger value from either left or top from current
                if (left != -1 || top != -1)
                    dp[row][col] = Math.max(left, top) + 1;

                // Update largest pointer
                if (dp[row][col] > largestValue) {
                    largestValue = dp[row][col];
                }
            }
        }

        return largestValue;
    }

    public int[][] readFile(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));

        // First two nums are rows and columns
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        int input[][] = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                input[i][j] = scanner.nextInt();
            }
        }
        return input;
    }
}
