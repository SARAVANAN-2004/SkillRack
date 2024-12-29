package set_2;
import java.util.*;

public class Minimum_Swaps_Descending_Order {
    
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner in = new Scanner(System.in);

        // Read the number of elements
        int n = in.nextInt();

        // Create an array to store the elements
        int[] arr = new int[n + 1];

        // Read the elements from the user
        for (int i = n; i >= 1; i--) {
            arr[i] = in.nextInt();
        }

        // Create an array to keep track of visited elements
        boolean[] vis = new boolean[n + 1];

        // Initialize the total number of swaps to 0
        int totalSwaps = 0;

        // Iterate through the array of elements
        for (int i = 1; i <= n; i++) {
            // If the current element has already been visited, continue to the next element
            if (vis[arr[i]]) {
                continue;
            }

            // If the current element is 1, mark it as visited and continue to the next element
            if (arr[i] == 1) {
                vis[arr[i]] = true;
                continue;
            }

            // Form cycle and count the number of edges in the cycle
            int edge = 0, cycleIdx = arr[i];
            while (!vis[cycleIdx]) {
                vis[cycleIdx] = true;
                edge++;
                cycleIdx = arr[cycleIdx];
            }

            // Add the number of edges in the cycle minus 1 to the total number of swaps
            totalSwaps += edge - 1;
        }

        // Print the total number of swaps
        System.out.println(totalSwaps);
    }
}