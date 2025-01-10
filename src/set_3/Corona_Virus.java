package set_3;
import java.util.*;

public class Corona_Virus {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read the dimensions of the grid
        int row = in.nextInt();
        int col = in.nextInt();

        // Create a 2D array to store the grid
        int[][] arr = new int[row][col];

        // Create a queue to store the coordinates of infected cells
        Queue<int[]> que = new LinkedList<>();

        // Initialize the grid and count healthy cells
        int healthy = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                arr[r][c] = in.nextInt();
                if (arr[r][c] == 1) {
                    healthy++;
                }
                if (arr[r][c] == 2) {
                    que.add(new int[]{r, c}); // Add initial infected cells to the queue
                }
            }
        }

        // Define directions for neighbor cells
        int[] adjR = {0, 0, 1, -1}; // Row offsets
        int[] adjC = {-1, 1, 0, 0}; // Column offsets

        int day = 0; // Initialize the day counter

        // BFS to simulate infection spread
        while (!que.isEmpty()) {
            int size = que.size(); // Number of cells infected on the current day

            for (int i = 0; i < size; i++) {
                int[] cur = que.poll(); // Get the current infected cell

                // Explore neighboring cells
                for (int j = 0; j < 4; j++) {
                    int r = cur[0] + adjR[j];
                    int c = cur[1] + adjC[j];

                    // Check if the neighbor cell is within bounds and healthy
                    if (r >= 0 && r < row && c >= 0 && c < col && arr[r][c] == 1) {
                        arr[r][c] = 2; // Infect the neighbor cell
                        healthy--; // Decrement the healthy cell count
                        que.add(new int[]{r, c}); // Add the newly infected cell to the queue
                    }
                }
            }

            if (!que.isEmpty()) {
                day++; // Increment the day if there are still cells to infect
            }
        }

        // Print the result
        if (healthy != 0) {
            System.out.println(-1); // If there are still healthy cells after the simulation, it's impossible to infect them all
        } else {
            System.out.println(day); // Print the number of days taken to infect all cells
        }
    }
}