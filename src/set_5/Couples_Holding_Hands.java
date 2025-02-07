package set_5;
import java.util.*;

public class Couples_Holding_Hands {

    // A map to store the value and its corresponding index in the array
    static Map<Integer, Integer> map;

    public static void main(String[] args) {
        // Scanner object to read input from the user
        Scanner in = new Scanner(System.in);

        // Read the number of elements in the array
        int n = in.nextInt();

        // Array to store the elements
        int[] row = new int[n];

        // Initialize the map
        map = new HashMap<>();

        // Read the elements into the array and store their indices in the map
        for (int i = 0; i < n; i++) {
            row[i] = in.nextInt();
            map.put(row[i], i);
        }

        // Variable to count the number of swaps
        int swaps = 0;

        // Iterate through the array in steps of 2
        for (int i = 0; i < n; i += 2) {
            int first = row[i];

            // Determine the expected second element based on the first element
            int second = first + (first % 2 == 0 ? 1 : -1);

            // If the next element is not the expected second element, perform a swap
            if (row[i + 1] != second) {
                swaps++;
                swap(row, i + 1, map.get(second));
            }
        }

        // Print the total number of swaps
        System.out.println(swaps);
    }

    // Method to swap two elements in the array and update their positions in the map
    public static void swap(int[] row, int i, int j) {
        int t = row[i];
        row[i] = row[j];
        row[j] = t;

        // Update the map with the new indices of the swapped elements
        map.put(row[i], i);
        map.put(row[j], j);
    }
}