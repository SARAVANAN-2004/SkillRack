package set_3;

import java.util.*;  // Importing the Java utility package for Scanner
import java.math.BigInteger;  // Importing BigInteger to handle large numbers

public class Pet_Store_Dogs {

    public static void main(String[] args) {
        // Scanner to read input from the console
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // Read an integer input for 'n'

        // Initialize an array of BigInteger to store results (to handle large numbers)
        BigInteger[] way = new BigInteger[n + 1];

        // Loop to calculate the values for each step up to 'n'
        for (int ctr = 1; ctr <= n; ctr++) {
            // Base case: For the first two steps, the result is simply ctr
            if (ctr <= 2) {
                way[ctr] = new BigInteger(ctr + "");  // Convert ctr to string and then to BigInteger
            } else {
                // For ctr > 2, calculate passive = (ctr - 1) * way[ctr - 2]
                BigInteger passive = new BigInteger((ctr - 1) + "")
                        .multiply(way[ctr - 2]);

                // way[ctr] = passive + way[ctr - 1]
                way[ctr] = passive.add(way[ctr - 1]);
            }
        }

        // Print the final result for way[n]
        System.out.println(way[n].toString());
    }
}
