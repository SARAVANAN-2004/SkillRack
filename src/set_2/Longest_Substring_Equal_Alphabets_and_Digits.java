package set_2;
import java.util.*;

public class Longest_Substring_Equal_Alphabets_and_Digits {

public static void main(String[] args) {
        // Your Code Here
        Scanner in = new Scanner(System.in);
        String s = in.next();

        // Create a HashMap to store the last occurrence of each count
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0); // Initialize with count 0 at index 0

        int maxLen = 0; // To store the maximum length of the substring
        int cnt = 0; // To keep track of the current count of non-digit characters

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                cnt--; // Decrease count for digit
            } else {
                cnt++; // Increase count for non-digit
            }

            // If the current count has been seen before, calculate the length of the substring
            if (map.containsKey(cnt)) {
                int curLen = i - map.get(cnt) + 1; // Calculate current substring length
                maxLen = Math.max(curLen, maxLen); // Update maxLen if necessary
            } else {
                // If the current count is not seen before, store it in the map
                map.put(cnt, i + 1);
            }
        }

        System.out.println(maxLen);
    }
}