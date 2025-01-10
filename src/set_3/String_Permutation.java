package set_3;
import java.util.Scanner;

public class String_Permutation {

    // Function to swap two characters in the character array
    public static void swap(char[] str, int x, int y) {
        char temp = str[x];   // Temporarily store the character at index x
        str[x] = str[y];      // Assign the character at index y to index x
        str[y] = temp;        // Assign the temporary character to index y
    }

    // Recursive function to generate permutations
    public static void permute(char[] str, int len, int swapIndex, int otherIdx) {
        // Base case: If the current index reaches the end of the string
        if (swapIndex == len - 1) {
            System.out.print(String.valueOf(str)+" "); // Print the generated permutation
            return;
        }

        // Swap the characters at swapIndex and otherIdx
        swap(str, swapIndex, otherIdx);

        // Recursively generate permutations for the next indices
        for (int idx = swapIndex + 1; idx < len; idx++) {
            permute(str, len, swapIndex + 1, idx);
        }

        // Backtrack: Undo the swap to restore the original state
        swap(str, swapIndex, otherIdx);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for input

        System.out.print("Enter a string: ");
        String input = scanner.next();            // Read the input string

        char[] str = input.toCharArray();         // Convert the string to a character array
        int len = str.length;                     // Find the length of the string
        int swapIndex = 0;                        // Initialize the starting index for swapping

        // Generate all permutations starting from each character
        for (int idx = 0; idx < len; idx++) {
            permute(str, len, swapIndex, idx);
        }

        scanner.close();                          // Close the scanner
    }
}
