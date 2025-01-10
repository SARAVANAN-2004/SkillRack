package set_3;
import java.util.*;  // Import the Java utility package for Scanner

public class Minimum_Edit_Distance_Two_Strings {

    public static void main(String[] args) {
        // Scanner to read input from the console
        Scanner in = new Scanner(System.in);

        // Read two input strings
        String s1 = in.next();
        String s2 = in.next();

        // Determine the lengths of the two strings
        int row = s2.length(), col = s1.length();

        // Initialize a 2D array (dp table) to store results
        int[][] dp = new int[row + 1][col + 1];

        // Fill the first column with incremental values (base case)
        for (int r = 0; r <= row; r++) {
            dp[r][0] = r;
        }

        // Fill the first row with incremental values (base case)
        for (int c = 0; c <= col; c++) {
            dp[0][c] = c;
        }

        // Populate the dp table by comparing characters of s1 and s2
        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= col; c++) {
                // If characters match, carry over the previous diagonal value
                if (s2.charAt(r - 1) == s1.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    // If characters don't match, take the minimum of three operations:
                    // 1. Delete (dp[r-1][c]),
                    // 2. Insert (dp[r][c-1]),
                    // 3. Replace (dp[r-1][c-1]) and add 1 to the result
                    dp[r][c] = Math.min(dp[r - 1][c],
                            Math.min(dp[r][c - 1], dp[r - 1][c - 1])) + 1;
                }
            }
        }

        // Print the result - the value at the bottom-right of the dp table
        System.out.println(dp[row][col]);
    }
}
