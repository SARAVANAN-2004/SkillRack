package set_5;
import java.util.*;

public class Cherry_Pickup {


    static int[][][] dp; // 3D DP array to store results for overlapping subproblems

    public static int cherryPickup(int[][] grid, int n) {
        // Initialize the DP array with -1 (indicating uncomputed states)
        dp = new int[n][n][n];

        for (int[][] rows : dp) {
            for (int[] row : rows) {
                Arrays.fill(row, -1);
            }
        }

        // Start solving from the top-left corner for both players (robots)
        int cherries = solve(grid, n, 0, 0, 0, 0);
        return Math.max(0,cherries);
    }

    public static int solve(int[][] grid, int n, int r1, int c1, int r2, int c2) {
        // If any robot moves out of bounds or encounters a blocked cell (-1), return 0
        if (r1 >= n || r2 >= n || c2 >= n || c1 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (r1 == n-1 && c1 == n-1){
            return  grid[r1][c1];
        }

        // If we have already computed the result for this state, return it
        if (dp[r1][r2][c1] != -1) {
            return dp[r1][r2][c1];
        }

        // Collect cherries at the current positions (avoid double counting)
        int value = grid[r1][c1];
        if (r1 != r2 || c1 != c2) { // If they are at different cells, collect both
            value += grid[r2][c2];
        }

        // Explore all possible movements for both robots:
        // - Right for both
        // - Right for one, Down for the other
        // - Down for one, Right for the other
        // - Down for both
        int rr = solve(grid, n, r1, c1 + 1, r2, c2 + 1);
        int rd = solve(grid, n, r1, c1 + 1, r2 + 1, c2);
        int dr = solve(grid, n, r1 + 1, c1, r2, c2 + 1);
        int dd = solve(grid, n, r1 + 1, c1, r2 + 1, c2);

        // Take the maximum cherries collected among all possible moves
        dp[r1][r2][c1] = value + Math.max(Math.max(rr, rd), Math.max(dr, dd));

        return dp[r1][r2][c1];
    }

    public static void main(String[] args) {
        // Taking input for grid size and the grid itself
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] grid = new int[n][n];

        // Reading the grid values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        // Compute and print the maximum cherries collected
        System.out.println(cherryPickup(grid, n));
    }
}

