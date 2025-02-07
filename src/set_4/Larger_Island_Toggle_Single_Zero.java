package set_4;
import java.util.*;

public class Larger_Island_Toggle_Single_Zero {

    // Global variables to track rows, columns, size of the connected component, and component count
    static int row, col, size = 0, cnt = 2;

    public static void main(String[] args) {
        // Reading input
        Scanner in = new Scanner(System.in);
        row = in.nextInt(); // Number of rows in the grid
        col = in.nextInt(); // Number of columns in the grid
        int[][] grid = new int[row][col]; // 2D grid to store the input

        // Filling the grid with input values
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                grid[r][c] = in.nextInt();
            }
        }

        // Map to store the size of each connected component identified
        Map<Integer, Integer> map = new HashMap<>();
        int maxi = 0; // Variable to track the maximum component size

        // Identify and calculate the size of all connected components
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1) { // If it's a part of a connected component
                    dfs(r, c, grid); // Perform DFS to mark and calculate the size
                    map.put(cnt, size); // Store the size of this component in the map
                    maxi = Math.max(size, maxi); // Update the maximum size if needed
                    cnt++; // Increment the component ID
                    size = 0; // Reset size for the next component
                }
            }
        }

        // Check each 0 cell to see if flipping it maximizes the connected component size
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 0) { // If it's a 0 cell
                    int val = 1; // Start with size 1 (the flipped cell itself)
                    int[] adjR = {-1, 1, 0, 0}; // Row offsets for adjacent cells
                    int[] adjC = {0, 0, -1, 1}; // Column offsets for adjacent cells
                    Set<Integer> set = new HashSet<>(); // To store unique connected component IDs

                    // Check all adjacent cells
                    for (int k = 0; k < 4; k++) {
                        int i = adjR[k] + r;
                        int j = adjC[k] + c;

                        // If the cell is valid and belongs to a unique component
                        if (valid(i, j) && !set.contains(grid[i][j])) {
                            val += map.getOrDefault(grid[i][j], 0); // Add the size of the component
                            set.add(grid[i][j]); // Mark this component as visited
                        }
                    }

                    maxi = Math.max(maxi, val); // Update the maximum size if needed
                }
            }
        }

        // Output the maximum size
        System.out.println(maxi);
    }

    // Helper method to check if a cell is within bounds
    public static boolean valid(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }

    // Depth First Search (DFS) to mark all cells of a connected component
    public static void dfs(int r, int c, int[][] grid) {
        // Base case: if the cell is invalid or not part of a component
        if (!valid(r, c) || grid[r][c] != 1) {
            return;
        }

        grid[r][c] = cnt; // Mark the cell with the component ID
        size++; // Increment the size of the current component

        // Recursive DFS calls for all four directions
        dfs(r + 1, c, grid); // Down
        dfs(r - 1, c, grid); // Up
        dfs(r, c + 1, grid); // Right
        dfs(r, c - 1, grid); // Left
    }
}
