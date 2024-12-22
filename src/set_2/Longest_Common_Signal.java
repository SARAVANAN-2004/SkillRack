package set_2;
import java.util.*;

public class Longest_Common_Signal {
        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            // Read two input strings from the user
            String s1 = in.next();
            String s2 = in.next();

            // Initialize variables
            int max = 0; // Stores the maximum length of common substring
            int n1 = s1.length(); // Length of the first string
            int n2 = s2.length(); // Length of the second string

            // Create a 2D array (DP table) to store lengths of common substrings
            // dp[i][j] stores the length of the longest common suffix of s1[0...i-1] and s2[0...j-1]
            int[][] dp = new int[n1 + 1][n2 + 1];

            // s1 -> row && s2 -> col (comment indicating how the DP table is indexed)

            // Iterate through the strings to populate the DP table
            for (int r = 1; r <= n1; r++) { // Iterate through rows (s1)
                for (int c = 1; c <= n2; c++) { // Iterate through columns (s2)

                    // Check if the characters at the current positions in s1 and s2 are equal
                    if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
                        // If the characters are equal, the length of the common suffix increases by 1
                        // It takes the value from the diagonally previous element + 1
                        dp[r][c] = dp[r - 1][c - 1] + 1;
                    } else {
                        // If the characters are not equal, the length of the common suffix is 0
                        // Although not explicitly set to 0 here, the default value of the int array is 0.
                    }
                    // Update the maximum length found so far
                    max = Math.max(dp[r][c], max);

                }
            }

            // Print the maximum length of the common substring
            System.out.println(max);

        }
    }