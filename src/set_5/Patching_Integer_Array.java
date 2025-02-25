package set_5;
import java.util.*;

public class Patching_Integer_Array {

    public static void main(String[] args) {
        // Scanner object to take input
        Scanner in = new Scanner(System.in);

        // Read the number of elements in the array
        int n = in.nextInt();

        // Declare an array of size n
        int[] arr = new int[n];

        // Read n elements into the array
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // Read the target number 'num'
        int num = in.nextInt();

        // Initialize variables
        long till = 0; // Tracks sum
        int cnt = 0;   // Count the number of steps
        int i = 0;     // Index for iteration

        // First loop: Process array elements while till < num and i < n
        while (i < n && till < num) {
            // If 'till' is greater than or equal to (arr[i] - 1), update 'till' using arr[i]
            if (till >= arr[i] - 1) {
                till += arr[i++]; // Add arr[i] and move to the next index
            } else {
                // Otherwise, increment 'till' optimally
                till += (till + 1);
                cnt++; // Increase step count
            }
        }

        // Second loop: If 'till' is still less than 'num', continue incrementing it
        while (till < num) {
            till += (till + 1);
            cnt++; // Increase step count
        }

        // Print the total number of steps required
        System.out.println(cnt);

        // Close scanner
        in.close();
    }
}
