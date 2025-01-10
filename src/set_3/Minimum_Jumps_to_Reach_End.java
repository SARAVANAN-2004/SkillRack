package set_3;
import java.util.*;  // Import the utilities package for Scanner class

public class Minimum_Jumps_to_Reach_End {

    public static void main(String[] args) {

        // Initialize Scanner to read input from the console
        Scanner in = new Scanner(System.in);

        // Read the number of elements in the array
        int n = in.nextInt();

        // If there's only one element, no jumps are needed
        if(n == 1){
            System.out.println(0);
            return;  // Exit the program
        }

        // Create an array to store the elements
        int[] arr = new int[n];

        // Read the array elements
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        // Initialize jump count to 1, maxIdx to the first element, and steps to the first element
        int jump = 1, maxIdx = arr[0], step = arr[0];

        // Iterate through the array starting from the second element
        for(int i = 1; i < n; i++){

            // If we reach the last element, stop the loop
            if(i == n - 1){
                break;
            }

            // Update maxIdx to the farthest reachable point
            maxIdx = Math.max(maxIdx, arr[i] + i);

            // Use one step
            step--;

            // If no more steps left
            if(step == 0){
                // Increment jump as we need to make a new one
                jump++;

                // Calculate remaining steps to reach maxIdx
                step = maxIdx - i;
            }
        }

        // Print the total number of jumps
        System.out.println(jump);
    }
}
