package set_2;
import java.util.*;

public class Word_Search_n_Matrix {

    // Declare static variables to store input and track state
    static int row, col;
    static boolean found;
    static char[][] arr;
    static String s;

    public static void main(String[] args) {
        // Get input from the user
        Scanner in = new Scanner(System.in);
        row = in.nextInt(); // Read the number of rows
        col = in.nextInt(); // Read the number of columns

        // Create a 2D array to store the characters
        arr = new char[row][col];

        // Read the characters into the array
        in.nextLine(); // Consume the newline character
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = in.next().charAt(0);
            }
        }

        // Read the string to search for
        s = in.next();

        // Check if the string exists in the array starting from each cell
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (arr[r][c] == s.charAt(0)) {
                    if (found) { // If the string was already found, exit
                        return;
                    }
                    valid(r, c, 0); // Start the recursive search
                    if (found) { // If the string was found, print "yes" and exit
                        System.out.println("yes");
                        return;
                    }
                }
            }
        }

        // If the string was not found, print "no"
        System.out.println("no");
    }

    // Recursive function to check if the string exists in the array
    public static void valid(int r, int c, int idx) {
        // Base case: If the index is equal to the length of the string, it means the string was found
        if (r >= 0 && r < row && c >= 0 && c < col) {
            if (idx == s.length()) {
                found = true;
                return;
            }

            // Check if the current cell matches the character at the current index
            if (arr[r][c] == s.charAt(idx)) {
                // Recursively check the adjacent cells in all four directions (up, down, left, right)
                char backup = arr[r][c]; // Store the original character
                arr[r][c] = '-'; // Temporarily mark the current cell as visited
                valid(r + 1, c, idx + 1); // Check down
                valid(r - 1, c, idx + 1); // Check up
                valid(r, c + 1, idx + 1); // Check right
                valid(r, c - 1, idx + 1); // Check left
                arr[r][c] = backup; // Restore the original character
            }
        }
    }
}