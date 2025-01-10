package set_3;
import java.util.*;

public class PalindromicPartition {

    public static void main(String[] args) {
        // Scanner to read input
        Scanner in = new Scanner(System.in);

        // Read the input string
        String s = in.next();
        int n = s.length();

        // Create a boolean array to store palindrome substrings
        boolean[][] palin = new boolean[n][n];

        // Initialize single character substrings as palindromes
        for (int i = 0; i < n; i++) {
            palin[i][i] = true;
        }

        // Check for two character palindromes
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                palin[i][i + 1] = true;
            }
        }

        // Check for palindromes of length 3 or more
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                // Check the start and end characters and the inner substring
                if (s.charAt(i) == s.charAt(i + len - 1) && palin[i + 1][i + len - 2]) {
                    palin[i][i + len - 1] = true;
                }
            }
        }

        // Create an array to store minimum splits for substrings
        Integer[][] splits = new Integer[n][n];

        // Calculate the minimum cuts needed to partition the string into palindromes
        int cnt = calc(s, n, palin, 0, n - 1, splits);

        // Print the result
        System.out.println(cnt);
    }

    // Function to calculate the minimum cuts for palindrome partitioning
    public static int calc(String s, int n, boolean[][] palin, int start, int end, Integer[][] split) {
        // If the substring is already a palindrome, no cuts are needed
        if (palin[start][end]) {
            return 0;
        }

        // If the value is already calculated, return it
        if (split[start][end] != null) {
            return split[start][end];
        }

        // Initialize minimum splits to the maximum possible value
        int minSplits = n;

        // Try making cuts at different positions
        for (int i = start; i < end; i++) {
            int curSplit = 1 + calc(s, n, palin, start, i, split) + calc(s, n, palin, i + 1, end, split);

            // Update the minimum splits if the current split is smaller
            if (curSplit < minSplits) {
                minSplits = curSplit;
            }
        }

        // Store the calculated result to avoid recalculations
        split[start][end] = minSplits;

        return minSplits;
    }
}
