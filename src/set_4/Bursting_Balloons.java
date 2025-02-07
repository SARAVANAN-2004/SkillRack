package set_4;
import java.util.*;

public class Bursting_Balloons {

    public static void main(String[] args) {

        // Initialize scanner to read input
        Scanner in = new Scanner(System.in);

        // Read the number of elements in the array
        int n = in.nextInt();

        // Create an array with two extra positions for boundary values
        int[] arr = new int[n + 2];

        // Set boundary values to 1
        arr[0] = 1;
        arr[n + 1] = 1;

        // Read input values into the array, starting from index 1
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }

        // Initialize DP table with -1 (to indicate uncomputed values)
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call the solve function and print the result
        System.out.println(solve(arr, dp, 1, n));
    }

    // Function to calculate the maximum cost using DP and recursion
    public static int solve(int[] arr, int[][] dp, int left, int right) {
        // Base case: If the range is invalid, return 0
        if (left > right) {
            return 0;
        }

        // If result is already computed, return it
        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        // Variable to store the maximum cost for the current range
        int maxi = 0;

        // Iterate over all possible partitions
        for (int idx = left; idx <= right; idx++) {
            // Calculate the cost for the current partition
            int cost = (arr[left - 1] * arr[idx] * arr[right + 1]) +
                    solve(arr, dp, left, idx - 1) + // Solve for left subarray
                    solve(arr, dp, idx + 1, right); // Solve for right subarray

            // Update the maximum cost
            maxi = Math.max(maxi, cost);
        }

        // Store the computed result in the DP table
        dp[left][right] = maxi;

        // Return the maximum cost for this range
        return maxi;
    }
}
