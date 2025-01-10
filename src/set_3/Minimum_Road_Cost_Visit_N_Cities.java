package set_3;
import java.util.*;

public class Minimum_Road_Cost_Visit_N_Cities {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read the number of cities (n) and roads (r)
        int n = in.nextInt();
        int r = in.nextInt();

        // Initialize an adjacency matrix to represent the graph
        int[][] matrix = new int[n + 1][n + 1];
        for (int[] row : matrix) {
            Arrays.fill(row, -1); // Fill with -1 to indicate no direct connection
        }

        // To keep track of visited nodes and minimum cost
        boolean[] visited = new boolean[n + 1];
        int minCost = Integer.MAX_VALUE; // Initialize minimum cost to a high value
        int minCostSrc = -1, minCostDest = -1; // Track source and destination of minimum cost edge

        // Input road information
        for (int i = 0; i < r; i++) {
            int curSrc = in.nextInt();
            int curDest = in.nextInt();
            int curCost = in.nextInt();

            // Update adjacency matrix for both directions
            matrix[curSrc][curDest] = curCost;
            matrix[curDest][curSrc] = curCost;

            // Track the minimum cost edge for initialization
            if (curCost < minCost) {
                minCost = curCost;
                minCostSrc = curSrc;
                minCostDest = curDest;
            }
        }

        // Initialize total minimum cost with the cost of the minimum edge
        int totalMinCost = minCost;
        int remCities = n - 2; // Remaining cities to be connected

        // Mark the source and destination of the minimum cost edge as visited
        visited[minCostSrc] = true;
        visited[minCostDest] = true;

        // Prim's Algorithm: Add the remaining cities to the MST
        while (remCities > 0) {
            minCost = Integer.MAX_VALUE;

            // Iterate through visited nodes to find the next minimum edge
            for (int city = 1; city <= n; city++) {
                if (visited[city]) { // Consider only visited cities
                    for (int oth = 1; oth <= n; oth++) {
                        // Skip already visited nodes and invalid edges
                        if (visited[oth] || city == oth || matrix[city][oth] == -1) {
                            continue;
                        }

                        // Update minimum cost edge if found
                        if (matrix[city][oth] < minCost) {
                            minCost = matrix[city][oth];
                            minCostDest = oth;
                        }
                    }
                }
            }

            // Add the selected edge to the total cost
            totalMinCost += minCost;

            // Mark the destination city as visited
            visited[minCostDest] = true;

            // Decrease the count of remaining cities
            remCities--;
        }

        // Output the total minimum cost of connecting all cities
        System.out.println(totalMinCost);
    }
}
