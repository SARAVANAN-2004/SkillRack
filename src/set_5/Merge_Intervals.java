package set_5;
import java.util.*;

public class Merge_Intervals {
    public static void main(String[] args) {
        // Scanner to take input
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // Number of intervals

        int[][] arr = new int[n][2]; // Array to store intervals

        // Read intervals from input
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt(); // Start of interval
            arr[i][1] = in.nextInt(); // End of interval
        }

        // Sort intervals based on start time (ascending order)
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int st = arr[0][0]; // Start of first interval
        int en = arr[0][1]; // End of first interval

        // Merge overlapping intervals
        for (int[] interval : arr) {
            if (interval[0] <= en) {
                // Extend the end if overlapping
                en = Math.max(en, interval[1]);
            } else {
                // Print the merged interval
                System.out.println(st + " " + en);
                st = interval[0];
                en = interval[1];
            }
        }

        // Print the last merged interval
        System.out.println(st + " " + en);
    }
}
