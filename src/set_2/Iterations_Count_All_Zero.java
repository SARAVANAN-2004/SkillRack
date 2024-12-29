package set_2;
import java.util.*;

public class Iterations_Count_All_Zero {

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

        // Read the value to be searched
        int k = in.nextInt();

        // Initialize a counter for the number of islands
        int iteration = 0;

        // Iterate through each cell in the maze
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                // If the current cell matches the value to be searched
                if (k == arr[r][c]) {
                    // Increment the island count
                    iteration++;
                    // Perform Depth First Search (DFS) to explore the connected island
                    dfs(arr, r, c, row, col);
                }
            }
        }

        // Print the number of islands found
        System.out.println(iteration);
    }

    // Depth First Search (DFS) function to explore connected components
    public static void dfs(int[][] arr, int r, int c, int row, int col) {
        // Base case: Out of bounds or cell value is 0 (already visited or not part of the island)
        if (r < 0 || r >= row || c < 0 || c >= col || arr[r][c] == 0) {
            return;
        }

        // Mark the current cell as visited
        arr[r][c] = 0;

        // Recursively explore neighboring cells
        dfs(arr, r + 1, c, row, col); // Down
        dfs(arr, r - 1, c, row, col); // Up
        dfs(arr, r, c + 1, row, col); // Right
        dfs(arr, r, c - 1, row, col); // Left
    }
}