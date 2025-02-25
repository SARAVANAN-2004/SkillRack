package set_5;
import java.util.*;

public class Sliding_Window_Median {

    // Class to maintain median efficiently
    static class Median {

        // Record to store number and its index in the array
        record E(long num, int idx) {}

        // Two heaps (TreeSets) to maintain the left (max heap) and right (min heap) halves
        TreeSet<E> left, right;

        // Constructor to initialize the heaps with appropriate comparators
        Median() {
            left = new TreeSet<>(Comparator.comparing(E::num).reversed().thenComparing(E::idx)); // Max heap
            right = new TreeSet<>(Comparator.comparing(E::num).thenComparing(E::idx)); // Min heap
        }

        // Add a number to the data structure
        void add(long num, int idx) {
            if (left.size() == right.size()) {
                left.add(new E(num, idx));   // Add to left (max heap)
                right.add(left.pollFirst()); // Move max from left to right
            } else {
                right.add(new E(num, idx));  // Add to right (min heap)
                left.add(right.pollFirst()); // Move min from right to left
            }
        }

        // Remove a number from the data structure
        void remove(long num, int idx) {
            if (!left.remove(new E(num, idx))) {
                right.remove(new E(num, idx)); // Remove from right if not found in left
            }

            // Rebalance the heaps if necessary
            if (left.size() > right.size()) {
                right.add(left.pollFirst());
            } else if (right.size() > left.size() + 1) {
                left.add(right.pollFirst());
            }
        }

        // Get the median of current window
        double median() {
            if (left.size() == right.size()) {
                return (left.first().num + right.first().num) / 2.0;
            }
            return right.first().num;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // Size of array
        int k = in.nextInt(); // Window size

        int[] arr = new int[n];
        Median mf = new Median(); // Instance of Median class

        // Insert first k elements into the window
        for (int i = 0; i < k; i++) {
            int x = in.nextInt();
            arr[i] = x;
            mf.add(x, i);
        }

        // Print the first median
        System.out.printf("%.1f ", mf.median());

        // Process the remaining elements using sliding window approach
        for (int i = k; i < n; i++) {
            mf.remove(arr[i - k], i - k); // Remove the oldest element
            int x = in.nextInt();
            arr[i] = x;
            mf.add(x, i); // Add the new element
            System.out.printf("%.1f ", mf.median());
        }

        in.close(); // Close scanner
    }
}
