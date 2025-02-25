package set_5;
import java.util.*;

public class Minimum_Flips_A_OR_B_Equals_C {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input three integers
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        // Find the maximum value among a, b, and c to determine the loop limit
        int max = Math.max(a, Math.max(b, c));

        int cnt = 0; // Counter for the number of flips
        int shift = 0; // Tracks the bit position

        // Iterate through each bit position as long as (1 << shift) is within max
        while ((1 << shift) <= max) {
            // Extract the current bit (shift-th bit) from a, b, and c
            int abit = (1 & (a >> shift));
            int bbit = (1 & (b >> shift));
            int cbit = (1 & (c >> shift));

            // If (abit | bbit) already matches cbit, no flip needed
            if ((abit | bbit) == cbit) {
                // No operation needed; continue to the next bit
            } else {
                // If cbit is 0, we need to turn off any set bits in a or b
                if (cbit == 0) {
                    if (abit == 1 && bbit == 1) {
                        cnt += 2; // Both bits need to be flipped to 0
                    } else {
                        cnt++; // Only one bit needs to be flipped to 0
                    }
                }
                // If cbit is 1, we need at least one bit set to 1
                else {
                    cnt++; // Flip one of the bits (either a or b) to 1
                }
            }

            // Move to the next bit position
            shift++;
        }

        // Output the number of flips needed
        System.out.println(cnt);
    }
}
