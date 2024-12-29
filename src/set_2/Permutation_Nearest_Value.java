package set_2;
import java.util.*;

public class Permutation_Nearest_Value {

    static int closest, x; // Declare static variables to store closest value and target number

    public static void main(String[] args) {
        // Your Code Here
        Scanner in = new Scanner(System.in);
        char[] n = in.next().toCharArray(); // Get the input string as character array
        x = in.nextInt(); // Get the target number

        // Initialize closest with the initial number
        closest = Integer.parseInt(String.valueOf(n));

        // Generate permutations and find the closest number
        permute(n, 0, n.length - 1);

        System.out.println(closest);
    }

    // Calculate absolute difference between two numbers
    public static int absDiff(int a, int b) {
        return a > b ? a - b : b - a;
    }

    // Recursive function to generate permutations
    public static void permute(char[] s, int l, int r) {
        if (l == r) { // Base case: If left and right pointers meet, a permutation is found
            int cur = Integer.parseInt(String.valueOf(s)); // Convert current permutation to integer
            if (absDiff(cur, x) < absDiff(closest, x)) { // Check if current number is closer to target
                closest = cur; // Update closest number if closer
            }
            return;
        }

        for (int idx = l; idx <= r; idx++) {
            swap(s, idx, l); // Swap current character with leftmost character
            permute(s, l + 1, r); // Recursively permute remaining characters
            swap(s, idx, l); // Backtrack: Swap back to original order
        }
    }

    // Helper function to swap two characters in the array
    public static void swap(char[] s, int i, int j) {
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }
}