package set_1;

import java.util.*;
public class Valid_Mix_of_String_Reverse {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner in = new Scanner(System.in);

        // Read the three strings from the user
        String s1 = in.next();
        String s2 = in.next();
        String mix = in.next();

        // Reverse the mix string
        StringBuilder sb = new StringBuilder(mix);
        String s3 = sb.reverse().toString();

        // Calculate the lengths of the strings
        int l1 = s1.length();
        int l2 = s2.length();
        int m = s3.length();

        // Check if the length of the mix string is equal to the sum of the lengths of s1 and s2
        if (m != l1 + l2) {
            System.out.println("NO");
            return;
        }

        // Call the isValid function to check if the reversed mix string (s3) is a valid combination of s1 and s2
        boolean valid = isValid(s1, s2, s3, l1, l2, m, 0, 0, 0);

        // Print the result
        System.out.println(valid ? "YES" : "NO");
    }

    // Recursive function to check if the reversed mix string (s3) is a valid combination of s1 and s2
    static boolean isValid(String s1, String s2, String s3, int l1, int l2, int m, int idx1, int idx2, int idx) {
        // Base case: if the entire reversed mix string has been processed, return true
        if (idx == m) {
            return true;
        }

        // Get the current character from the reversed mix string
        char ch = s3.charAt(idx);

        // If the current character matches both s1 and s2 at the current indices,
        // recursively check both possibilities (taking the character from s1 or s2)
        if (idx1 < l1 && idx2 < l2 && ch == s1.charAt(idx1) && ch == s2.charAt(idx2)) {
            return isValid(s1, s2, s3, l1, l2, m, idx1 + 1, idx2, idx + 1) ||
                    isValid(s1, s2, s3, l1, l2, m, idx1, idx2 + 1, idx + 1);
        }

        // If the current character only matches s1 at the current index,
        // recursively check the possibility of taking the character from s1
        else if (idx1 < l1 && ch == s1.charAt(idx1)) {
            return isValid(s1, s2, s3, l1, l2, m, idx1 + 1, idx2, idx + 1);
        }

        // If the current character only matches s2 at the current index,
        // recursively check the possibility of taking the character from s2
        else if (idx2 < l2 && ch == s2.charAt(idx2)) {
            return isValid(s1, s2, s3, l1, l2, m, idx1, idx2 + 1, idx + 1);
        }

        // If the current character doesn't match any character at the current indices,
        // return false
        else {
            return false;
        }
    }
}