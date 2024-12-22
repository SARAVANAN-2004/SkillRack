package set_2;
import java.util.*;

public class Stair_Climbing_Slippery_stairs {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner in = new Scanner(System.in);

        // Read input values
        int n = in.nextInt(); // Number of steps
        int s = in.nextInt(); // Number of different leap sizes
        int t = in.nextInt(); // Number of slippery steps

        // Create an array to store leap sizes
        int[] leaps = new int[s];
        for (int i = 0; i < s; i++) {
            leaps[i] = in.nextInt();
        }

        // Create a set to store slippery steps
        Set<Integer> slipery = new HashSet<>();
        for (int i = 0; i < t; i++) {
            int x = in.nextInt();
            slipery.add(x);
        }

        // Create an array to store the number of ways to reach each step
        long[] ways = new long[n + 1];
        ways[0] = 1; // There is one way to reach the starting step (step 0)

        // Calculate the number of ways to reach each step
        for (int step = 1; step <= n; step++) {
            for (int leap = 0; leap < s; leap++) {
                if (step >= leaps[leap]) {
                    ways[step] += ways[step - leaps[leap]];
                }
            }

            // Handle slippery steps
            if (slipery.contains(step)) {
                int lastStep = step - 1;
                while (slipery.contains(lastStep)) {
                    lastStep--;
                }
                if (lastStep > 0) {
                    ways[lastStep] += ways[step];
                }
                ways[step] = 0; // Reset ways to 0 for this slippery step
            }
        }

        // Print the number of ways to reach the final step
        System.out.println("N " + ways[n]);
    }
}