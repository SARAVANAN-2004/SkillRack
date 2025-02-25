package set_5;
import java.util.*;

public class Non_Overlapping_Intervals {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2];

        // Reading input: Each interval has a start and end time
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt(); // Start time
            arr[i][1] = in.nextInt(); // End time
        }

        // Sorting intervals by end time
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        int prev = arr[0][1]; // Store the end time of the first interval
        int cnt = 1; // At least one interval is chosen

        // Counting non-overlapping intervals
        for (int i = 1; i < n; i++) {
            if (prev <= arr[i][0]) { // If current interval doesn't overlap
                prev = arr[i][1]; // Update the last chosen interval's end time
                cnt++; // Increase count of non-overlapping intervals
            }
        }

        // Minimum removals to make the rest non-overlapping
        System.out.println(n - cnt);
    }
}
