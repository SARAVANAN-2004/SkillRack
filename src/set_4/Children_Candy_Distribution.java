package set_4;
import java.util.*;

public class Children_Candy_Distribution {

   public static void main(String[] args) {
        // Scanner to read input from the user
        Scanner in = new Scanner(System.in);

        // Read the number of elements in the array
        int n = in.nextInt();

        // Initialize an array to store the input values
        int[] arr = new int[n];

        // Read the elements of the array
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // dp array to store the lengths of increasing sequences
        int[] dp = new int[n];

        // Fill dp array with 1 (each element is a sequence of length 1 by itself)
        Arrays.fill(dp, 1);

        // Forward pass to calculate the longest increasing subsequence ending at each position
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                dp[i + 1] = Math.max(dp[i] + 1, dp[i + 1]);
            }
        }

        // Backward pass to ensure correctness in handling decreasing subsequences
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                dp[i - 1] = Math.max(dp[i] + 1, dp[i - 1]);
            }
        }

        // Calculate the sum of the dp array and print the result
        System.out.println(Arrays.stream(dp).sum());
    }
}
