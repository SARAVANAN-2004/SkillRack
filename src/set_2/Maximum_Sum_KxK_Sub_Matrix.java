package set_2;
import java.util.*;

public class Maximum_Sum_KxK_Sub_Matrix {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read the number of rows and columns
        int row = in.nextInt();
        int col = in.nextInt();

        // Create a 2D array to store the row-wise prefix sums
        int[][] rowSum = new int[row][col + 1];

        // Calculate the row-wise prefix sums
        for (int r = 0; r < row; r++) {
            for (int c = 1; c <= col; c++) {
                int curr = in.nextInt();
                rowSum[r][c] = curr + rowSum[r][c - 1];
            }
        }

        // Read the size of the submatrix
        int k = in.nextInt();

        // Initialize the maximum sum to the minimum possible value
        int sum = Integer.MIN_VALUE;

        // Iterate over all possible submatrices
        for (int r = 0; r < row - k + 1; r++) {
            for (int c = 1; c <= col - k + 1; c++) {
                int curSum = 0;

                // Calculate the sum of the current submatrix using prefix sums
                for (int srow = r; srow < r + k; srow++) {
                    curSum += rowSum[srow][c + k - 1] - rowSum[srow][c - 1];
                }

                // Update the maximum sum if necessary
                sum = Math.max(sum, curSum);
            }
        }

        // Print the maximum sum
        System.out.println(sum);
    }
}