package set_2;
import java.util.*;

public class Island_Count {

    static  int row,col;
    // Your Code Here
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read the number of rows and columns
         row = in.nextInt();
         col = in.nextInt();

        // Create a 2D array to store the maze
        int[][] arr = new int[row][col];

        // Read the maze data from input
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        // Initialize a counter for the number of islands
        int cnt = 0;

        // Iterate through each cell in the maze
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                // If the current cell is part of an island (value is 1) and hasn't been visited yet
                if (arr[r][c] == 1) {
                    // Increment the island count
                    cnt++;
                    // Perform Depth First Search (DFS) to explore and mark the island as visited
                    dfs(arr, r, c);
                }
            }
        }

        // Print the number of islands found
        System.out.println(cnt);
    }

    // Depth First Search (DFS) function to explore connected components
    public static void dfs(int[][] arr, int r, int c) {
        // Base case: Out of bounds or cell value is not 1 (already visited or not part of the island)
        if (r < 0 || r >= row || c < 0 || c >= col || arr[r][c] != 1) {
            return;
        }

        // Mark the current cell as visited
        arr[r][c] = 2;

        // Recursively explore neighboring cells (including diagonals)
        dfs(arr, r + 1, c); // Down
        dfs(arr, r - 1, c); // Up
        dfs(arr, r, c + 1); // Right
        dfs(arr, r, c - 1); // Left
        dfs(arr, r - 1, c - 1); // Top-Left
        dfs(arr, r - 1, c + 1); // Top-Right
        dfs(arr, r + 1, c - 1); // Bottom-Left
        dfs(arr, r + 1, c + 1); // Bottom-Right
    }
}