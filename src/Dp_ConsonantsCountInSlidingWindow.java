import java.util.Scanner;

public class Dp_ConsonantsCountInSlidingWindow {

    // Function to check if a character is a vowel (case-insensitive)
    private static boolean isVowel(char ch) {
        char ch1 = Character.toLowerCase(ch); // Convert character to lowercase
        return ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u';
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Get window size (K) from user
        int K = in.nextInt();

        // Get the string (S) from user
        String S = in.next();

        int N = S.length(); // Get the length of the string

        int count = 0; // Initialize count of consonants in the window

        // Count consonants in the initial window of size K
        for (int i = 0; i < K; i++) {
            if (!isVowel(S.charAt(i))) { // Check if character is not a vowel
                count++;
            }
        }

        // Print the count for the initial window
        System.out.print(count + " ");

        // Use a sliding window approach to count consonants in sub-strings
        for (int i = 1; i <= N - K; i++) {
            // Remove the leading character (if not a vowel) from the window
            if (!isVowel(S.charAt(i - 1))) {
                count--;
            }

            // Add the trailing character (if not a vowel) to the window
            if (!isVowel(S.charAt(i + K - 1))) {
                count++;
            }

            // Print the count for the current window
            System.out.print(count + " ");
        }
    }
}