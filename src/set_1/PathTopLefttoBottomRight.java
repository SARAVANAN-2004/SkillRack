package set_1;

import java.util.Scanner;
public class PathTopLefttoBottomRight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read the dimensions of the matrix
        int R = in.nextInt(); // Number of rows
        int C = in.nextInt(); // Number of columns

        // Declare the matrix and path arrays
        int[][] matrix = new int[R][C]; // Input matrix with 1s (path) and 0s (stone)
        int[][] path = new int[R][C]; // Auxiliary matrix to store the number of paths

        // Input the matrix and initialize the path array to 0
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                matrix[row][col] = in.nextInt();
                path[row][col] = 0; // Initialize the path matrix
            }
        }

        // Set the starting point (top-left cell)
        path[0][0] = matrix[0][0];

        // Populate the first row (can only move right)
        for (int col = 1; col < C; col++) {
            if (matrix[0][col] == 1) {
                path[0][col] = path[0][col - 1];
            }
        }

        // Populate the first column (can only move down)
        for (int row = 1; row < R; row++) {
            if (matrix[row][0] == 1) {
                path[row][0] = path[row - 1][0];
            }
        }

        // Fill the rest of the matrix (can move either right or down)
        for (int row = 1; row < R; row++) {
            for (int col = 1; col < C; col++) {
                // If the current cell is passable (value is 1), calculate the number of paths
                if (matrix[row][col] == 1) {
                    path[row][col] = path[row][col - 1] + path[row - 1][col];
                }
            }
        }

        // Check the bottom-right cell to determine if there's a path
        if (path[R - 1][C - 1] > 0) {
            // Print "Yes" followed by the number of paths
            System.out.print("Yes ");
            System.out.print(path[R - 1][C - 1]);
        } else {
            // If no path exists, print "No"
            System.out.print("No");
        }
    }
}
