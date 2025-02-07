package set_5;
import java.util.*; // Importing utility package for Scanner and Arrays

public class Reduce_Dishes {

    public static void main(String[] args) {
        // Creating a Scanner object for user input
        Scanner in = new Scanner(System.in);

        // Reading the number of dishes
        int n = in.nextInt();

        // Array to store the tastiness values of the dishes
        int[] arr = new int[n];

        // Reading tastiness values from user input
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // Sorting the tastiness values in ascending order
        Arrays.sort(arr);

        // Variable to store the maximum possible sum
        int max = 0;

        // DP table to store the maximum sum values
        int[][] dp = new int[n + 1][n + 1];

        // Dynamic programming approach to calculate the maximum sum
        for(int dish = 1; dish <= n; dish++) { // Iterating through dishes
            for(int time = 1; time <= dish; time++) { // Iterating through possible times
                // Calculating max tastiness sum for current dish and time
                dp[dish][time] = dp[dish - 1][time - 1] + arr[dish - 1] * time;

                // Updating the maximum sum found so far
                max = Math.max(max, dp[dish][time]);
            }
        }

        // Printing the final maximum tastiness sum
        System.out.println(max);
    }
}
