package set_2;
import java.util.*;

public class Robot_Stair_Climbing {
    public static void main(String[] args) {
        // Your Code Here

        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // Number of stairs

        int leap = in.nextInt(); // Number of different leap sizes
        int[] leaps = new int[leap]; // Array to store leap sizes

        for (int i = 0; i < leap; i++) {
            leaps[i] = in.nextInt(); // Read each leap size
        }

        long[] ways = new long[n + 1]; // Array to store the number of ways to reach each stair
        ways[0] = 1; // There is only one way to reach the 0th stair

        for (int step = 1; step <= n; step++) {
            for (int i = 0; i < leap; i++) {
                if (step >= leaps[i]) { // Check if the current leap size is valid for the current stair
                    ways[step] += ways[step - leaps[i]]; // Add the number of ways to reach the previous stair with the current leap size
                }
            }
        }

        System.out.println(ways[n]); // Print the number of ways to reach the nth stair
    }
}