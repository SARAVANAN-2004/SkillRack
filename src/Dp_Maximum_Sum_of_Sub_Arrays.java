import java.util.Scanner;

public class Dp_Maximum_Sum_of_Sub_Arrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Get the size (N) of the array from the user
        int N = in.nextInt();

        // Declare an array (arr) to store the input integers
        int[] arr = new int[N];

        // Read N integers from the user and store them in the array
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        // Initialize variables to track the current sum (currSum) and maximum sum (maxSum) found so far
        int currSum = arr[0];
        int maxSum = arr[0];

        // Iterate through the array starting from the second element (i = 1)
        for (int i = 1; i < N; i++) {
            // Calculate the current sum: either the previous sum + current element OR just the current element
            // This considers if the previous elements contributed negatively to the sum.
            currSum = Math.max(currSum + arr[i], arr[i]);

            // Update the maximum sum if the current sum is greater
            maxSum = Math.max(currSum, maxSum);
        }

        // Print the maximum sum found in the array
        System.out.print(maxSum);
    }
}
