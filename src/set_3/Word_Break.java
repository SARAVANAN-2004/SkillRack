package set_3;
import java.util.*;

public class Word_Break {

   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] words = in.nextLine().split(" "); // Split words into an array
        String s = in.next();                     // Input string to be segmented
        Set<String> set = new HashSet<>(Arrays.asList(words)); // Create set for quick lookup
        breakWord(set, s, "", 0); // Call the recursive function
        in.close();
    }

    public static void breakWord(Set<String> set, String s, String output, int start) {
        // Base case: If start index equals string length, print the output and return
        if (start == s.length()) {
            System.out.println(output.trim());
            return;
        }

        // Loop through the string to form substrings
        for (int i = start; i < s.length(); i++) {
            String word = s.substring(start, i + 1); // Extract substring from start to i
            if (set.contains(word)) {               // Check if the word exists in the set
                breakWord(set, s, output + word + " ", i + 1); // Recursive call
            }
        }
    }
}
