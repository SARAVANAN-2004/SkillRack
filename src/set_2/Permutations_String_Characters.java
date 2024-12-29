package set_2;
import java.util.*;

public class Permutations_String_Characters {

    public static void main(String[] args) {
        // Your Code Here
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();

        // Call the permute function to generate permutations
        permute(s, 0, s.length - 1);
    }

    public static void permute(char[] s, int left, int right) {
        // Base case: If left and right pointers meet, a permutation is found
        if (left == right) {
            System.out.println(String.valueOf(s));
            return;
        }

        // Generate permutations recursively
        for (int idx = left; idx <= right; idx++) {
            // Swap the current character with the character at the leftmost position
            swap(s, left, idx);

            // Recursively permute the remaining characters
            permute(s, left + 1, right);

            // Backtrack: Swap the characters back to their original positions
            swap(s, left, idx);
        }
    }

    public static void swap(char[] s, int i, int r) {
        char ch = s[i];
        s[i] = s[r];
        s[r] = ch;
    }
}