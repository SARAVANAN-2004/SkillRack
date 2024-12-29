package set_2;
import java.util.*;

public class DP_Array_Elements_Equal_Left_Right_Sum {

    public static void main(String[] args) {
        // Your Code Here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n + 1];
        long[] dp = new long[n + 1];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int x = in.nextInt();
            sum += x;
            arr[i] = x;
            dp[i] = sum;
        }
        for (int i = 1; i <= n; i++) {
            if (dp[i - 1] == dp[n] - dp[i]) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
