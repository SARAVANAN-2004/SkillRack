package set_3;
import java.util.*;  // Import the entire java.util package to use Scanner class

public class Find_Single_Value_Repeated_Odd_Times {

    public static void main(String[] args) {  // Main method, entry point of the program
        Scanner in = new Scanner(System.in);  // Create a Scanner object to read input
        int n = in.nextInt();  // Read the number of integers to be input
        int result = 0;  // Initialize result to 0, will hold the XOR result

        // Loop through 'n' times to read integers and compute XOR
        for(int i = 0; i < n; i++) {
            int x = in.nextInt();  // Read the next integer
            result ^= x;  // Perform XOR operation with current result and x
        }

        System.out.println(result);  // Print the final XOR result
    }
}
