
import java.util.Scanner;

public class Path_Bottom_Left_to_Top_Right {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] arr = new int[row][col];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                arr[i][j] = in.nextInt();
            }
        }
        int[][] dp  = new int[row][col];
        dp[row-1][0] = arr[row-1][0];
        // fill the first column
        for(int r = row-2;r>=0;r--){
            if(arr[r][0] == 1){
                dp[r][0] = dp[r+1][0];
            }
        }
        // fill the last row
        for(int c = 1;c<col;c++){
            if(arr[row-1][c] == 1){
                dp[row-1][c] = dp[row-1][c-1];
            }
        }

        // fill the remaining
        for(int r = row-2;r>=0;r--){
            for(int c = 1;c<col;c++){
                if(arr[r][c] == 1){
                    dp[r][c] = dp[r][c-1]+dp[r+1][c];
                }
            }
        }
        if(dp[0][col-1] == 0){
            System.out.println("no");
        }else {
            System.out.println("yes "+dp[0][col-1]);
        }
    }
}
