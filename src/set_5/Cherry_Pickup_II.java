package set_5;
import java.util.*;

public class Cherry_Pickup_II {

    static int row, col;
    static int[][][] dp; // 3D DP array to store results of overlapping subproblems

    public static void main(String[] args) {
        // Taking input from the user
        Scanner in = new Scanner(System.in);
        row = in.nextInt(); // Number of rows
        col = in.nextInt(); // Number of columns

        // Creating the grid
        int[][] grid = new int[row][col];

        // Reading the grid values
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                grid[r][c] = in.nextInt();
            }
        }

        // Compute and print the maximum cherries collected
        System.out.println(cherryPickup(grid));
    }

    public static int cherryPickup(int[][] grid) {
        // Initializing DP array with -1 (to indicate uncomputed states)
        dp = new int[row][col][col];
        for (int[][] rows : dp) {
            for (int[] row : rows) {
                Arrays.fill(row, -1);
            }
        }

        // Start solving from the first row, with two robots starting at (0,0) and (0, col-1)
        int cherries = solve(grid, 0, 0, col - 1);
        return cherries;
    }

    public static int solve(int[][] grid, int r, int c1, int c2) {
        // Base case: if either robot moves out of bounds, return 0
        if (c1 < 0 || c2 < 0 || c1 >= col || c2 >= col) {
            return 0;
        }

        // If result is already computed, return the stored value
        if (dp[r][c1][c2] != -1) {
            return dp[r][c1][c2];
        }

        // Collect cherries at the current positions
        int cherry = grid[r][c1];
        if (c1 != c2) { // If both robots are not in the same cell, collect both cherries
            cherry += grid[r][c2];
        }

        // If this is the last row, return the collected cherries
        if (r == row - 1) {
            return cherry;
        }

        int maxi = 0;

        // Explore all possible movements for both robots:
        // Both robots can move in three directions: left (-1), stay (0), or right (+1)
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                maxi = Math.max(maxi, solve(grid, r + 1, c1 + dj1, c2 + dj2));
            }
        }

        // Store the result in DP array and return
        return dp[r][c1][c2] = cherry + maxi;
    }
}
