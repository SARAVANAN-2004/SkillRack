package set_2;
import java.util.*;

public class Largest_Possible_Odd_Integer {

  public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner in = new Scanner(System.in);

        // Read the input number
        long n = in.nextLong();

        // Create an array to store the frequency of each digit
        int[] dp = new int[10];

        // Count the frequency of each digit in the input number
        while (n > 0) {
            int rem = (int) (n % 10); // Get the last digit
            n /= 10;                  // Remove the last digit
            dp[rem]++;                // Increment the frequency of the digit
        }

        // Find the first odd digit that has a non-zero frequency
        int unitDigit = -1;
        for (int i = 1; i < 10; i += 2) {
            if (dp[i] > 0) {
                dp[i]--; // Decrement the frequency of the chosen digit
                unitDigit = i;
                break;
            }
        }

        // If no odd digit is found, print "no" and exit
        if (unitDigit == -1) {
            System.out.println("no");
            return;
        }

        // Construct the new number using the remaining digits
        long ans = 0;
        for (int i = 9; i >= 0; i--) {
            for (int cnt = 0; cnt < dp[i]; cnt++) {
                ans = (ans * 10) + i;
            }
        }

        // Append the chosen odd digit to the end
        ans = (ans * 10) + unitDigit;

        // Print the new number
        System.out.println(ans);
    }
}