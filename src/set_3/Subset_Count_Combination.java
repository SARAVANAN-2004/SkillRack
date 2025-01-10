package set_3;
import java.util.*;

public class Subset_Count_Combination {

    // Main method - Entry point of the program
    public static void main(String[] args) {
        // Initialize scanner to take input from the user
        Scanner in = new Scanner(System.in);

        // Read the number of elements in the array
        int n = in.nextInt();

        // Variable to hold the total sum of the array elements
        int totalSum = 0;

        // Array to store the input values
        int[] arr = new int[n];

        // Read array elements and compute total sum
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            totalSum += arr[i];
        }

        // DP matrix to track possible subset sums
        boolean[][] matrix = new boolean[n + 1][totalSum + 1];

        // Dynamic Programming to calculate subset sums
        for (int row = 1; row <= n; row++) {
            int cur = arr[row - 1];  // Current element from the array

            // Loop through possible sums
            for (int sum = 0; sum <= totalSum; sum++) {
                // Check if sum can be formed using the current element or previous subset
                if (sum >= cur && (sum == cur || matrix[row - 1][sum - cur])) {
                    matrix[row][sum] = true;  // Mark subset sum as possible
                } else {
                    matrix[row][sum] = matrix[row - 1][sum];  // Inherit from previous subset
                }
            }
        }

        // Count how many even subset sums are possible
        int row = n;
        int cnt = 0;
        for (int sum = 2; sum <= totalSum; sum += 2) {
            if (matrix[row][sum]) {
                cnt++;  // Increment count if even sum is found
            }
        }

        // Print the count of even subset sums
        System.out.println(cnt);
    }
}
