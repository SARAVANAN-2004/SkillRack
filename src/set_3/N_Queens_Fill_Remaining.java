package set_3;
import java.util.*;

public class N_Queens_Fill_Remaining {


    public static void main(String[] args) {
        // Read input for the size of the board
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n]; // The chessboard representation

        // Boolean flags to mark rows, columns, and diagonals as occupied
        boolean[] rflag = new boolean[n];       // Row flags
        boolean[] cflag = new boolean[n];       // Column flags
        boolean[] nwDiag = new boolean[(2 * n) - 1]; // North-West diagonal flags
        boolean[] swDiag = new boolean[(2 * n) - 1]; // South-West diagonal flags

        // Read the initial board configuration
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
                if (arr[i][j] == 1) { // If there's already a queen at (i, j)
                    rflag[i] = true;
                    cflag[j] = true;
                    nwDiag[i + j] = true;
                    swDiag[j - i + n - 1] = true;
                }
            }
        }

        // Solve the N-Queens problem and print the solution
        boolean found = solve(0, n, arr, rflag, cflag, nwDiag, swDiag);
        print(arr, n); // Print the board
    }

    // Method to solve the N-Queens problem using backtracking
    public static boolean solve(int row, int n, int[][] arr, boolean[] rflag, boolean[] cflag, boolean[] nwDiag, boolean[] swDiag) {
        // Base case: If all rows are processed, a solution is found
        if (row == n) {
            return true;
        }

        // Skip rows that are already occupied
        if (rflag[row]) {
            return solve(row + 1, n, arr, rflag, cflag, nwDiag, swDiag);
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            if (valid(row, col, n, rflag, cflag, nwDiag, swDiag)) {
                // Place the queen
                rflag[row] = true;
                cflag[col] = true;
                nwDiag[row + col] = true;
                swDiag[col - row + n - 1] = true;
                arr[row][col] = 1;

                // Recur for the next row
                if (solve(row + 1, n, arr, rflag, cflag, nwDiag, swDiag)) {
                    return true;
                }

                // Backtrack: Remove the queen
                rflag[row] = false;
                cflag[col] = false;
                nwDiag[row + col] = false;
                swDiag[col - row + n - 1] = false;
                arr[row][col] = 0;
            }
        }

        // No valid placement found for this row
        return false;
    }

    // Method to validate if a queen can be placed at (row, col)
    public static boolean valid(int row, int col, int n, boolean[] rflag, boolean[] cflag, boolean[] nwDiag, boolean[] swDiag) {
        // Check if the current position is under attack
        return !(rflag[row] || cflag[col] || nwDiag[row + col] || swDiag[col - row + n - 1]);
    }

    // Method to print the chessboard
    public static void print(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
