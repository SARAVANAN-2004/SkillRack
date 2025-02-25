package set_4;
import java.util.*;
class Pair {
    int step;
    String s;

    // Constructor for the Pair class
    public Pair(String s, int step) {
        this.s = s;
        this.step = step;
    }
}

public class Word_Ladder {

    public static void main(String[] args) {
        // Taking input from the user
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // Number of words in the dictionary
        String begin = in.next();  // Starting word
        String end = in.next();  // Target word

        // Set to store dictionary words
        Set<String> set = new HashSet<>();
        Queue<Pair> queue = new ArrayDeque<>();

        // Reading words into the set
        for (int i = 0; i < n; i++) {
            set.add(in.next());
        }

        // BFS initialization
        queue.add(new Pair(begin, 1));  // Start BFS from 'begin' with step 1
        set.remove(begin);  // Remove 'begin' from the dictionary to avoid revisiting

        // BFS traversal
        while (!queue.isEmpty()) {
            int step = queue.peek().step;  // Current step count
            String s = queue.peek().s;  // Current word
            queue.poll();  // Remove the current word from the queue

            // If we reach the target word, print steps and exit
            if (s.equals(end)) {
                System.out.println(step);
                return;
            }

            // Generate all possible one-letter transformations
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    char[] word = s.toCharArray();
                    word[i] = (char) ('a' + j);  // Replace character at position i
                    String str = String.valueOf(word);  // Convert array to string

                    // If the transformed word is in the dictionary
                    if (set.contains(str)) {
                        queue.add(new Pair(str, step + 1));  // Add new word with incremented step
                        set.remove(str);  // Remove from set to prevent revisiting
                    }
                }
            }
        }

        // If transformation is not possible, print 0
        System.out.println(0);
    }
}
