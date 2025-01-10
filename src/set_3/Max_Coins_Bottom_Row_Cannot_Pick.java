package set_3;
import java.util.*;  // Import the Java utility package for using Scanner and Arrays

public class Max_Coins_Bottom_Row_Cannot_Pick {


    public static void main(String[] args) {
        // Scanner to read input from the console
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // Number of test cases

        // Loop through each test case
        for(int i = 0; i < n; i++) {
            int row = in.nextInt();  // Number of rows in the matrix
            int col = in.nextInt();  // Number of columns in the matrix

            // Initialize a 2D array (matrix) to store input values
            int[][] arr = new int[row][col];

            // Fill the matrix with input values
            for(int r = 0; r < row; r++) {
                for(int c = 0; c < col; c++) {
                    arr[r][c] = in.nextInt();
                }
            }

            // Call the helper function to process the matrix
            helper(arr, row, col);
        }
    }

    // Helper function to process the matrix and compute results
    public static void helper(int[][] arr, int row, int col) {
        // Dynamic programming array to store computed values
        int[][] dp = new int[row][col];

        // Initialize the first row of dp with values from the input matrix
        for(int i = 0; i < col; i++) {
            dp[0][i] = arr[0][i];
        }

        // Iterate over the remaining rows
        for(int r = 1; r < row; r++) {
            // Copy the previous row for comparison
            int[] prevrow = Arrays.copyOf(dp[r - 1], col);

            // Sort the copied array to find the maximum and second maximum values
            Arrays.sort(prevrow);
            int firstmax = prevrow[col - 1];  // Largest value in the row
            int secondmax = prevrow[col - 2]; // Second largest value

            // Fill the current row of dp based on the previous row values
            for(int c = 0; c < col; c++) {
                // If the value in the previous row is not the maximum, add the maximum
                if(dp[r - 1][c] != firstmax) {
                    dp[r][c] = firstmax + arr[r][c];
                } else {
                    // If the value is the maximum, add the second maximum
                    dp[r][c] = secondmax + arr[r][c];
                }
            }
        }

        // Sort the last row to find the maximum value
        Arrays.sort(dp[row - 1]);
        // Print the largest value from the last row
        System.out.println(dp[row - 1][col - 1]);
    }
}
