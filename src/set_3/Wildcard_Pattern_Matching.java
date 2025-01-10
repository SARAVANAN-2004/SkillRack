package set_3;
import java.util.*;

public class Wildcard_Pattern_Matching {


    public static void main(String[] args) {
        // Create a Scanner to accept user input
        Scanner in = new Scanner(System.in);

        // Read the text and wildcard pattern from the input
        String text = in.next();
        String pattern = in.next();

        // Calculate the dimensions of the DP table
        int row = text.length();
        int col = pattern.length();

        // Initialize a 2D boolean DP table
        boolean[][] dp = new boolean[row + 1][col + 1];

        // Base case: An empty text and empty pattern match
        dp[0][0] = true;

        // Handle cases where the pattern starts with '*'
        if (pattern.charAt(0) == '*') {
            dp[0][1] = true; // '*' matches an empty sequence
        }

        // Build the DP table row by row
        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= col; c++) {
                // Case 1: Pattern character is '?' or matches the text character
                if (pattern.charAt(c - 1) == '?' || pattern.charAt(c - 1) == text.charAt(r - 1)) {
                    dp[r][c] = dp[r - 1][c - 1]; // Use the result from the previous diagonal cell
                }
                // Case 2: Pattern character is '*'
                else if (pattern.charAt(c - 1) == '*') {
                    dp[r][c] = dp[r][c - 1] || dp[r - 1][c]; // '*' can match an empty sequence or any sequence
                }
                // Case 3: No match (default is false, so no action needed)
            }
        }

        // Check the result in the bottom-right cell of the DP table
        System.out.println(dp[row][col] ? "Matching" : "Not matching");
    }
}
