package set_3;
import java.util.*;

public class Selling_Wine_Bottles {


    public static void main(String[] args) {
        // Your Code Here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = in.nextInt();
        }

        int[][] max = new int[n][n];
        System.out.println(func(price, max, 0, n - 1, 1));
    }

    public static int func(int[] prices, int[][] max, int left, int right, int year) {
        if (max[left][right] != 0) {
            return max[left][right];
        }

        if (left == right) {
            return prices[left] * year;
        }

        int leftrev = prices[left] * year + func(prices, max, left + 1, right, year + 1);
        int rightrev = prices[right] * year + func(prices, max, left, right - 1, year + 1);

        max[left][right] = Math.max(leftrev, rightrev);
        return max[left][right];
    }
}