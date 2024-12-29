package set_2;
import java.util.*;

public class Combination_Zero_Sum {

   public static void main(String[] args) {
        // Your Code Here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // Array to store the input numbers
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // Count the number of subsets with sum 0
        int count = 0;

        // Iterate through all possible subsets using bitmasking
        for (int ctr = 0; ctr < (1 << n); ctr++) {
            int sum = 0;
            boolean valid = false; // Flag to indicate if the subset is non-empty

            // Iterate through each element in the array
            for (int bmi = 0; bmi < n; bmi++) {
                // Check if the current element is included in the subset
                if ((ctr & (1 << bmi)) != 0) {
                    sum += arr[bmi];
                    valid = true; // Set the flag to true since the subset is non-empty
                }
            }

            // If the sum is 0 and the subset is non-empty, increment the count
            if (sum == 0 && valid) {
                count++;
            }
        }

        System.out.println(count);
    }
}