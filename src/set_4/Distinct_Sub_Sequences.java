package set_4;
import java.util.*;

public class Distinct_Sub_Sequences {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int n = s.length(), m = t.length();
        int[][] dp = new int[n][m];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println(solve(n - 1, m - 1, s, t, dp));
    }

    public static int solve(int i, int j, String s, String t, int[][] dp) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = solve(i - 1, j - 1, s, t, dp) + solve(i - 1, j, s, t, dp);
        }
        return dp[i][j] = solve(i - 1, j, s, t, dp);
    }
}
