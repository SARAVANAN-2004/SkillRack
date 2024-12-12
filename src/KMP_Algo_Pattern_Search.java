import java.util.*;

public class KMP_Algo_Pattern_Search {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        char[] txt = in.next().toCharArray(); // Get the text from user input
        char[] pat = in.next().toCharArray(); // Get the pattern from user input

        int keyLen = pat.length; // Length of the pattern
        int LEN = txt.length; // Length of the text

        // lps[] array to store the longest proper prefix which is also a suffix
        int[] lps = new int[keyLen];
        int len = 0; // Length of the previous longest prefix

        // Calculate lps[] array
        for (int i = 1; i < keyLen;) {
            if (pat[len] == pat[i]) { // If characters match
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) { // If no match found yet
                    i++;
                } else {
                    len = lps[len - 1]; // Reduce the length of the previous prefix
                }
            }
        }

        // System.out.println(Arrays.toString(lps)); // Uncomment to print lps array

        int cnt = 0; // Count of pattern occurrences
        int ki = 0; // Index for the pattern

        // Search for pattern in the text
        for (int i = 0; i < LEN;) {
            if (txt[i] == pat[ki]) { // If characters match
                ki++;
                i++;
                if (ki == keyLen) { // If the entire pattern is matched
                    cnt++;
                    ki = 0;
                }
            } else {
                if (ki == 0) { // If no match found yet
                    i++;
                } else {
                    ki = lps[ki - 1]; // Reduce the index of the pattern
                }
            }
        }

        System.out.println("Count=" + cnt);
    }
}