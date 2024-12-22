package set_2;
import java.util.*;

public class Stair_Climbing_Damaged_Stairs {
    // Your Code Here
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Read input values
        int n = in.nextInt(); // Number of stairs
        int s = in.nextInt(); // Number of leap types
        int t = in.nextInt(); // Number of blocked stairs

        // Read leap types
        int[] leaps = new int[s];
        for (int i = 0; i < s; i++) {
            leaps[i] = in.nextInt();
        }

        // Create a set to store blocked stairs
        Set<Integer> blockedStairs = new HashSet<>();
        for (int i = 0; i < t; i++) {
            int x = in.nextInt();
            blockedStairs.add(x);
        }

        // Initialize an array to store the number of ways to reach each stair
        long[] ways = new long[n + 1];
        ways[0] = 1; // Base case: There is 1 way to reach the 0th stair

        // Calculate the number of ways to reach each stair
        for (int step = 1; step <= n; step++) {
            if (blockedStairs.contains(step)) {
                continue; // Skip blocked stairs
            }

            for (int leap = 0; leap < s; leap++) {
                if (step >= leaps[leap]) {
                    ways[step] += ways[step - leaps[leap]];
                }
            }
        }

        System.out.println(ways[n]); // Print the number of ways to reach the nth stair
    }
}