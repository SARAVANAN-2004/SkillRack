package set_1;

import java.util.*;
public class Valid_Mix_of_String_Values {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner in = new Scanner(System.in);

        // Read the three strings from the user
        String str1 = in.next();
        String str2 = in.next();
        String mix = in.next();

        // Calculate the lengths of the strings
        int len1 = str1.length();
        int len2 = str2.length();
        int mixlen = mix.length();

        // Check if the length of the mix string is equal to the sum of the lengths of str1 and str2
        if (mixlen != len1 + len2) {
            System.out.println("NO");
            return;
        }

        // Call the isValidMix function to check if the mix string is a valid combination of str1 and str2
        boolean isValid = isValidMix(str1, str2, mix, len1, len2, mixlen, 0, 0, 0);

        // Print the result
        System.out.println(isValid ? "YES" : "NO");
    }

    // Recursive function to check if the mix string is a valid combination of str1 and str2
    static boolean isValidMix(String str1, String str2, String mix, int len1, int len2, int mixlen, int idx1, int idx2, int mixIndex) {
        // Base case: if the entire mix string has been processed, return true
        if (mixIndex == mixlen) {
            return true;
        }

        // Get the current character from the mix string
        char ch = mix.charAt(mixIndex);

        // If the current character matches both str1 and str2 at the current indices,
        // recursively check both possibilities (taking the character from str1 or str2)
        if (idx1 < len1 && idx2 < len2 && ch == str1.charAt(idx1) && ch == str2.charAt(idx2)) {
            return isValidMix(str1, str2, mix, len1, len2, mixlen, idx1 + 1, idx2, mixIndex + 1) ||
                    isValidMix(str1, str2, mix, len1, len2, mixlen, idx1, idx2 + 1, mixIndex + 1);
        }

        // If the current character only matches str1 at the current index,
        // recursively check the possibility of taking the character from str1
        else if (idx1 < len1 && ch == str1.charAt(idx1)) {
            return isValidMix(str1, str2, mix, len1, len2, mixlen, idx1 + 1, idx2, mixIndex + 1);
        }

        // If the current character only matches str2 at the current index,
        // recursively check the possibility of taking the character from str2
        else if (idx2 < len2 && ch == str2.charAt(idx2)) {
            return isValidMix(str1, str2, mix, len1, len2, mixlen, idx1, idx2 + 1, mixIndex + 1);
        }

        // If the current character doesn't match any character at the current indices,
        // return false
        else {
            return false;
        }
    }
}