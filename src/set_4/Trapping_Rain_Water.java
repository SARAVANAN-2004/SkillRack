package set_4;
import java.util.*;

public class Trapping_Rain_Water {

   public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);

        // Input the size of the array
        int n = in.nextInt();

        // Initialize pointers for two ends of the array
        int l = 0, r = n - 1;

        // Create an array to store the heights
        int[] arr = new int[n];

        // Input the array elements (heights of the blocks)
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // Initialize variables to keep track of max heights from both sides
        int lmax = arr[0], rmax = arr[n - 1];

        // Variable to store the total water trapped
        int water = 0;

        // Use a two-pointer approach to calculate the water trapped
        while (l < r) {
            // If the left height is smaller or equal to the right height
            if (arr[l] <= arr[r]) {
                l++; // Move the left pointer forward
                lmax = Math.max(arr[l], lmax); // Update the max height on the left
                if (lmax > arr[l]) { // If water can be trapped at the current position
                    water += lmax - arr[l]; // Add the trapped water
                }
            } else { // If the right height is smaller
                r--; // Move the right pointer backward
                rmax = Math.max(arr[r], rmax); // Update the max height on the right
                if (rmax > arr[r]) { // If water can be trapped at the current position
                    water += rmax - arr[r]; // Add the trapped water
                }
            }
        }

        // Print the total water trapped
        System.out.println(water);
    }
}
