package set_4;
import java.util.*;

public class Matrix_Longest_Increasing_Path {

    public static void main(String[] args) {
        // Reading input using Scanner
        Scanner in = new Scanner(System.in);

        // Number of rows and columns in the matrix
        int row = in.nextInt();
        int col = in.nextInt();

        // Initializing the matrix
        int[][] matrix = new int[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                // Filling matrix with input values
                matrix[r][c] = in.nextInt();
            }
        }

        // DP array to store intermediate results
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], -1); // Initialize dp array with -1 (unvisited)
        }

        int max = 0; // Variable to store the maximum result

        // Traverse the matrix to calculate the longest increasing path
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (dp[r][c] == -1) { // If not already computed, call DFS
                    dp[r][c] = dfs(r, c, dp, matrix, row, col, -1);
                }
                // Update the maximum path length
                max = Math.max(dp[r][c], max);
            }
        }

        // Output the maximum length of the increasing path
        System.out.println(max);
    }

    // Depth-First Search to calculate the longest increasing path
    public static int dfs(int r, int c, int[][] dp, int[][] matrix, int row, int col, int prev) {
        // Base case: Check for out-of-bound indices
        if (r < 0 || r >= row || c < 0 || c >= col) {
            return 0;
        }

        // If the current value is not greater than the previous value, stop recursion
        if (matrix[r][c] <= prev) {
            return 0;
        }

        // If already computed, return the stored result
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        // Update the previous value to the current matrix value
        prev = matrix[r][c];

        // Explore all 4 possible directions
        int left = dfs(r, c - 1, dp, matrix, row, col, prev) + 1;
        int right = dfs(r, c + 1, dp, matrix, row, col, prev) + 1;
        int top = dfs(r - 1, c, dp, matrix, row, col, prev) + 1;
        int bottom = dfs(r + 1, c, dp, matrix, row, col, prev) + 1;

        // Store the maximum path length in dp array
        dp[r][c] = Math.max(Math.max(left, right), Math.max(top, bottom));

        return dp[r][c]; // Return the result
    }
}
