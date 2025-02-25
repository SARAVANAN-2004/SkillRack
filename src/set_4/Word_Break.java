package set_4;
import java.util.*;

public class Word_Break {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String s = in.next();   // Input string
            int n = in.nextInt();   // Number of words in dictionary
            String[] wordDict = new String[n];

            // Read dictionary words
            for (int i = 0; i < n; i++) {
                wordDict[i] = in.next();
            }

            // Print result based on DP solution
            System.out.println(solve(s, wordDict)?"Yes":"No");
        }

        public static boolean solve(String s, String[] wordDict) {
            int n = s.length();
            boolean[] dp = new boolean[n + 1]; // DP array to store results
            dp[n] = true; // Base case: empty string can always be segmented

            // Iterate from right to left (backwards)
            for (int st = n - 1; st >= 0; st--) {
                for (String word : wordDict) {
                    int m = word.length();
                    // Check if substring matches the dictionary word
                    if (st + m <= n && s.substring(st, st + m).equals(word)) {
                        dp[st] = dp[st + m]; // If true, mark current position
                    }

                    // If we found a valid segmentation, break early
                    if (dp[st]) {
                        break;
                    }
                }
            }

            return dp[0]; // If true, entire string can be segmented
        }
    }
