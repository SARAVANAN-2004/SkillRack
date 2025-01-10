package set_3;
import java.util.*;  // Importing all utility classes

public class Power_Points_Split {


    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner in = new Scanner(System.in);

        // Read an integer input from the user
        int n = in.nextInt();

        // Create an integer array of size n+1 (to handle up to n elements)
        int[] arr = new int[n + 1];

        // Initialize the first element
        arr[1] = 1;

        // Loop through 2 to n to calculate maximum values
        for (int i = 2; i <= n; i++) {
            // Loop to partition the number in different ways
            for (int singlePart = 1; singlePart < i; singlePart++) {
                int remPart = i - singlePart;  // Remaining part after partition
                // Calculate the current value using partition
                int curVal = singlePart * Math.max(remPart, arr[remPart]);

                // Store the maximum value found so far in arr[i]
                arr[i] = Math.max(arr[i], curVal);
            }
        }

        // Print the maximum value for n
        System.out.println(arr[n]);
    }
}
