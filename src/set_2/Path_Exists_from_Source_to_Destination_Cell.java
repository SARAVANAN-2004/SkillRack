package set_2;
import java.util.*;

public class Path_Exists_from_Source_to_Destination_Cell {


    // Your Code Here
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read the number of rows and columns
        int row = in.nextInt();
        int col = in.nextInt();

        // Create a 2D array to store the maze
        int[][] arr = new int[row][col];

        // Read the maze data from input
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        // Read the starting and ending coordinates
        int str = in.nextInt();
        int stc = in.nextInt();
        int endr = in.nextInt();
        int endc = in.nextInt();

        // Check if the starting and ending points are valid (i.e., 1)
        if (arr[str][stc] == 1 && arr[endr][endc] == 1 && canReach(arr, str, stc, endr, endc, row, col)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    // Recursive function to check if a path exists between two points in the maze
    public static boolean canReach(int[][] arr, int r, int c, int er, int ec, int row, int col) {
        // Base case: Reached the destination
        if (r == er && c == ec) {
            return true;
        }

        // Base case: Out of bounds or blocked cell
        if (r < 0 || r >= row || c < 0 || c >= col || arr[r][c] != 1) {
            return false;
        }

        // Mark the current cell as visited (to avoid cycles)
        arr[r][c] = 2;

        // Recursively check all four directions (up, down, left, right)
        return canReach(arr, r + 1, c, er, ec, row, col) || // Down
                canReach(arr, r - 1, c, er, ec, row, col) || // Up
                canReach(arr, r, c + 1, er, ec, row, col) || // Right
                canReach(arr, r, c - 1, er, ec, row, col);   // Left
    }
}