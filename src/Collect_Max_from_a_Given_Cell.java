import java.util.Scanner;

public class Collect_Max_from_a_Given_Cell {
    public static void main(String[] args) {
        // Your Code Here
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] arr = new int[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                arr[r][c] = in.nextInt();
            }
        }

        int[][] dp = new int[row][col];
        int posR = in.nextInt();
        int posC = in.nextInt();
        dp[posR][posC] = arr[posR][posC];

        for (int r = posR + 1; r < row; r++) {
            dp[r][posC] = dp[r - 1][posC] + arr[r][posC];
        }

        for (int c = posC + 1; c < col; c++) {
            dp[posR][c] = dp[posR][c - 1] + arr[posR][c];
        }

        for (int r = posR + 1; r < row; r++) {
            for (int c = posC + 1; c < col; c++) {
                dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]) + arr[r][c];
            }
        }

        System.out.println(dp[row - 1][col - 1]);
    }
}
