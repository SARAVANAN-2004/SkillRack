package set_1;

import java.util.*;
public class SubArrray_Sum {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner in = new Scanner(System.in);

        // Read the number of elements in the array
        int n = in.nextInt();

        // Create an array to store the elements
        int[] arr = new int[n];

        // Read the elements of the array from the console
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // Read the target sum
        int sum = in.nextInt();

        // Initialize variables
        int l = 0, r = 0, total = arr[0];

        // Sliding window approach
        while (r< n) {
            // If the current sum equals the target sum, print "Yes" and return
            if (total == sum) {
                System.out.println("Yes");
                return;
            }

            // If the current sum is less than the target sum, expand the window
            else if (total < sum) {
                r++;
                if (r < n) {
                    total += arr[r];
                }
            }

            // If the current sum is greater than the target sum, shrink the window
            else {
                total -= arr[l++];
            }
        }

        // If the loop completes without finding the target sum, print "No"
        if (total == sum) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}