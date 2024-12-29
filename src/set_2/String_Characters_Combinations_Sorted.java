package set_2;
import java.util.*;

public class String_Characters_Combinations_Sorted {
        public static void main(String[] args) {
            // Your Code Here
            Scanner in = new Scanner(System.in);
            String s = in.next();

            // Create a list to store all possible substrings
            List<String> values = new ArrayList<>();

            // Generate all possible substrings using bitmasking
            for (int cnt = 0; cnt < (1 << s.length()); cnt++) {
                StringBuilder str = new StringBuilder();

                // Iterate through each character in the string
                for (int bmi = 0; bmi < s.length(); bmi++) {
                    // Check if the bit at position bmi is set in the current mask (cnt)
                    if ((cnt & (1 << bmi)) != 0) {
                        str.append(s.charAt(bmi)); // Append the character to the substring
                    }
                }

                // If the substring is not empty, add it to the list
                if (str.length() > 0) {
                    values.add(str.toString());
                }
            }

            // Sort the list of substrings
            Collections.sort(values);

            // Print all substrings in sorted order
            for (String val : values) {
                System.out.println(val);
            }
        }
    }
