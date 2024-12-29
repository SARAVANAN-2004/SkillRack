package set_2;
import java.util.*;

public class Smallest_Possible_Odd_Integer {


    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);
        // Read the long number from the user
        long N = sc.nextLong();

        // Create an array to store the count of each digit (0-9)
        int[] count = new int[10];

        // Initialize a variable to store the largest odd digit encountered
        int unit = -1;

        // Extract digits from the number N one by one using a while loop
        while (N > 0) {
            // Get the last digit of N using the modulo operator (%)
            int digit = (int) (N % 10);

            // Increment the count of the extracted digit in the count array
            count[digit]++;

            // Remove the last digit from N by dividing it by 10
            N /= 10;
        }

        // Iterate through the count array in descending order (starting from 9)
        for (int digit = 9; digit >= 1; digit -= 2) {
            // Check if the current digit has any occurrences (count[digit] > 0)
            if (count[digit] > 0) {
                // If an odd digit is found, store it in the unit variable and decrement its count
                unit = digit;
                count[digit]--;
                break; // Exit the loop after finding the first odd digit
            }
        }

        // Check if no odd digit was found
        if (unit == -1) {
            System.out.print("no");
            return; // Exit the program if no odd digit is present
        }

        // Flag to check if any non-zero even digit was found
        boolean nonZero = false;

        // Iterate through the count array in ascending order (starting from 1)
        for (int digit = 1; digit <= 9; digit++) {
            // Check if the current digit (even digit) has any occurrences (count[digit] > 0)
            if (count[digit] > 0) {
                // If a non-zero even digit is found, print it, decrement its count, and set the nonZero flag
                System.out.print(digit);
                count[digit]--;
                nonZero = true;
                break; // Exit the loop after printing the first non-zero even digit
            }
        }

        // Print leading zeros if there were non-zero even digits and there are any zeros remaining
        if (nonZero) {
            while (count[0] > 0) {
                System.out.print(0);
                count[0]--;
            }
        }

        // Print the remaining digits (including even digits) based on their counts
        for (int digit = 1; digit <= 9; digit++) {
            while (count[digit] > 0) {
                System.out.print(digit);
                count[digit]--;
            }
        }

        // Print the largest odd digit found earlier
        System.out.print(unit);
    }
}