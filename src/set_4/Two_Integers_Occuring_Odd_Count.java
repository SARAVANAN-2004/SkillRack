package set_4;
import java.util.*;

public class Two_Integers_Occuring_Odd_Count {

    public static void main(String[] args) {
        // Initialize scanner to read input
        Scanner in = new Scanner(System.in);

        // Read the number of elements in the array
        int n = in.nextInt();

        // Create an array of size n
        int[] arr = new int[n];

        // Variable to store XOR of all elements
        int xor = 0;

        // Read the elements of the array and calculate the XOR of all elements
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            xor ^= arr[i];
        }

        // Initialize two groups to 0
        int group1 = 0, group2 = 0;

        // Find the rightmost set bit in the XOR (used to distinguish the two unique numbers)
        int distinguish = xor & -xor;

        // Divide numbers into two groups based on the distinguish bit
        for (int num : arr) {
            if ((distinguish & num) > 0) {
                // If the distinguish bit is set, XOR into group1
                group1 ^= num;
            } else {
                // If the distinguish bit is not set, XOR into group2
                group2 ^= num;
            }
        }

        // Print the two unique numbers in ascending order
        if (group1 < group2) {
            System.out.println(group1 + " " + group2);
        } else {
            System.out.println(group2 + " " + group1);
        }
    }
}
