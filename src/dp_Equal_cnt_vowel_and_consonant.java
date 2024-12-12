
import java.util.*;
public class dp_Equal_cnt_vowel_and_consonant {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner in = new Scanner(System.in);

        // Read the input string and convert it to lowercase characters
        char[] arr = in.next().toLowerCase().toCharArray();

        // Read the desired substring length
        int len = in.nextInt();

        // Initialize a variable to count the number of balanced substrings
        int cnt = 0;

        // Create a HashSet to store the vowels (a, e, i, o, u)
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        // Initialize a variable to keep track of the balance of vowels and consonants
        int balance = 0;

        // Iterate through the first len characters of the string
        for (int i = 0; i < len; i++) {
            if (set.contains(arr[i])) {
                // If the character is a vowel, increase the balance
                balance++;
            } else {
                // If the character is a consonant, decrease the balance
                balance--;
            }
        }

        // If the balance is 0 after processing the first len characters,
        // it means we have found a balanced substring
        if (balance == 0) {
            cnt++;
        }

        // Iterate through the remaining characters of the string
        for (int i = len; i < arr.length; i++) {
            // If the character at i - len is a vowel, decrease the balance
            if (set.contains(arr[i - len])) {
                balance--;
            } else {
                // If the character at i - len is a consonant, increase the balance
                balance++;
            }

            // If the current character is a vowel, increase the balance
            if (set.contains(arr[i])) {
                balance++;
            } else {
                // If the current character is a consonant, decrease the balance
                balance--;
            }

            // If the balance is 0 at this point, we have found another balanced substring
            if (balance == 0) {
                cnt++;
            }
        }

        // Print the total number of balanced substrings
        System.out.println(cnt);
    }
}