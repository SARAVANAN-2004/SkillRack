package set_1;

import java.util.Scanner;

public class Game_Collect_Maximum_Points {
    public static void main(String[] args) {
        // Your Code Here
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();

        // Read the matrix elements
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        // Create a DP table to store the maximum sum paths
        int[][] dp = new int[row][col];

        // Initialize the first row of the DP table
        dp[0][0] = arr[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = arr[0][i] + dp[0][i - 1];
        }

        // Initialize the first column of the DP table
        for (int i = 1; i < row; i++) {
            dp[i][0] = arr[i][0] + dp[i - 1][0];
        }

        // Fill the rest of the DP table
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]) + arr[r][c];
            }
        }

        System.out.println(dp[row - 1][col - 1]);
    }
}
