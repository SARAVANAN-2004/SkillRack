import java.util.Scanner;

public class Characters_in_at_least_N_minus_1_String_Values {
    public static void main(String[] args) {
        // Your Code Here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // Array to store the frequency of each character in all strings
        int[] arr = new int[128];

        // Process each string
        for (int i = 0; i < n; i++) {
            String s = in.next();

            // Array to store the frequency of each character in the current string
            int[] curcnt = new int[128];

            // Count the frequency of each character in the current string
            for (char ch : s.toCharArray()) {
                if (curcnt[ch] == 0 && (arr[ch] == i - 1 || arr[ch] == i)) {
                    // If the character is seen for the first time in the current string
                    // and it was either seen in all previous strings or never seen before,
                    // increment its frequency in the `arr` array
                    arr[ch]++;
                    curcnt[ch]++; // Increment the frequency in the current string's count array
                }

            }
        }

        // Print characters that appear in all but one string
        for (int i = 0; i < 128; i++) {
            if (arr[i] >= n - 1) {
                System.out.print((char) i);
            }
        }
    }
}
