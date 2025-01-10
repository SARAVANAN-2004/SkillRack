package set_3;
import java.util.*;

public class Largest_Square_Sub_Matrix_with_s {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input dimensions of the matrix
        int row = in.nextInt();
        int col = in.nextInt();

        // Input the binary matrix
        int[][] arr = new int[row][col];
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = in.nextInt();
                if (i == 0 || j == 0) {
                    dp[i][j] = arr[i][j];
                }
            }
        }

        int max = 1; // Maximum size of square submatrix
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                if (arr[r][c] == 1) {
                    dp[r][c] = Math.min(dp[r - 1][c - 1],
                            Math.min(dp[r - 1][c], dp[r][c - 1])) + 1;
                    max = Math.max(max, dp[r][c]);
                }
            }
        }

        // Output the maximum size
        System.out.println(max);
    }
}
