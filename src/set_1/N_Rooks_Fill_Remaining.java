package set_1;

import java.util.*;
public class N_Rooks_Fill_Remaining {
    // Your Code Here
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // Get the size of the chessboard

        boolean[] rookRow = new boolean[n]; // Array to track occupied rows
        boolean[] rookCol = new boolean[n]; // Array to track occupied columns
        int[][] arr = new int[n][n]; // 2D array to represent the chessboard

        // Read the initial positions of rooks
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
                if (arr[i][j] == 1) {
                    rookRow[i] = true; // Mark the row as occupied
                    rookCol[j] = true; // Mark the column as occupied
                }
            }
        }

        // Solve the rook placement problem
        solve(arr, rookRow, rookCol, n, 0);

        // Print the final arrangement of rooks
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Recursive function to solve the rook placement problem
    public static void solve(int[][] arr, boolean[] rookRow, boolean[] rookCol, int n, int row) {
        // Base case: If all rows are processed, return
        if (row == n) {
            return;
        }

        // If the current row is already occupied, move to the next row
        if (rookRow[row]) {
            solve(arr, rookRow, rookCol, n, row + 1);
            return;
        }

        // Try placing a rook in each empty column of the current row
        for (int col = 0; col < n; col++) {
            if (!rookCol[col]) {
                // Place the rook
                arr[row][col] = 1;
                rookCol[col] = true;
                rookRow[row] = true;

                // Recursively solve for the remaining rows
                solve(arr, rookRow, rookCol, n, row + 1);

                return;
            }
        }
    }
}