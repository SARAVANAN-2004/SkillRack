package set_3;
import java.util.*;

public class Longest_Palindromic_Substring {

   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next(); // Input string
        int n = s.length(); // Length of the input string

        // A DP table to store whether a substring is a palindrome
        boolean[][] matrix = new boolean[n][n];

        int maxLen = 1; // Variable to store the length of the longest palindrome

        // Step 1: Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            matrix[i][i] = true;
        }

        // Step 2: Check for palindromes of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) { // If two consecutive characters are the same
                matrix[i][i + 1] = true; // Mark as palindrome
                maxLen = 2; // Update maximum palindrome length
            }
        }

        // Step 3: Check for palindromes of length >= 3
        for (int len = 3; len <= n; len++) { // Loop for substring lengths
            for (int i = 0; i <= n - len; i++) { // Loop for starting index of substring
                int j = i + len - 1; // Ending index of substring

                // Check if the current substring is a palindrome
                if (s.charAt(i) == s.charAt(j) && matrix[i + 1][j - 1]) {
                    matrix[i][j] = true; // Mark as palindrome
                    maxLen = len; // Update maximum palindrome length
                }
            }
        }

        // Print the length of the longest palindromic substring
        System.out.println(maxLen);
    }
}
