package set_4;
import java.util.*;

public class Coins_Change_Minimum_Required {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input the number of coins
        int n = in.nextInt();

        // Input the target amount
        int amount = in.nextInt();

        // Array to store the coin denominations
        int arr[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // Initialize the DP table
        int[][] dp = new int[n][amount + 1];

        // Fill the DP table
        for (int am = 1; am <= amount; am++) {  // Iterate over all amounts
            for (int r = 0; r < n; r++) {       // Iterate over all coins
                int coin = arr[r];

                // If the coin is greater than the amount
                if (am < coin) {
                    if (r != 0) {
                        // Exclude the current coin and use the previous value
                        dp[r][am] = dp[r - 1][am];
                    } else {
                        // If this is the first row, initialize to MAX_VALUE
                        dp[r][am] = Integer.MAX_VALUE;
                    }
                } else {
                    // Include the current coin
                    int include = dp[r][am - coin] != Integer.MAX_VALUE ? dp[r][am - coin] + 1 : Integer.MAX_VALUE;

                    // Exclude the current coin
                    int exclude = r != 0 ? dp[r - 1][am] : Integer.MAX_VALUE;

                    // Take the minimum of including or excluding the current coin
                    dp[r][am] = Math.min(include, exclude);
                }
            }
        }

        // Print the result
        // If dp[n-1][amount] is not MAX_VALUE, print the value; otherwise, print -1
        System.out.println(dp[n - 1][amount] != Integer.MAX_VALUE ? dp[n - 1][amount] : -1);
    }
}
