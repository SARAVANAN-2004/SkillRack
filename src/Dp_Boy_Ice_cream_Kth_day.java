import java.util.*;
public class Dp_Boy_Ice_cream_Kth_day {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read the number of days and a variable 'k'
        int n = in.nextInt();
        int k = in.nextInt();

        // Create arrays to store the number of chocolates and ice creams for each day
        long[] choc = new long[n + 1];
        long[] icecream = new long[n + 1];

        // Initialize the first day's values: 1 chocolate and 1 ice cream
        choc[1] = icecream[1] = 1;

        // Dynamically calculate the number of chocolates and ice creams for each day
        for (int day = 2; day <= n; day++) {
            // The number of chocolates on the current day is the sum of chocolates and ice creams from the previous day
            choc[day] = choc[day - 1] + icecream[day - 1];

            // The number of ice creams on the current day is equal to the number of chocolates from the previous day
            icecream[day] = choc[day - 1];

            // If the current day is divisible by k, we add the previous day's ice cream count to the current day's ice cream count
            if (day % k == 0) {
                icecream[day] += icecream[day - 1];
            }
        }

        // Print the total number of chocolates and ice creams on the last day
        System.out.println(choc[n] + icecream[n]);
    }
}