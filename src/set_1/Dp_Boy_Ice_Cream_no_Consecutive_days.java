package set_1;

import java.util.*;
public class Dp_Boy_Ice_Cream_no_Consecutive_days {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input the number of days
        int N = in.nextInt();

        // Arrays to store the number of ways to have chocolate and ice-cream on each day
        int[] choc = new int[N + 1];
        int[] ice = new int[N + 1];

        // Base case: On the first day, there is only one way to have chocolate or ice-cream
        choc[1] = 1;
        ice[1] = 1;

        // Iterate over days from 2 to N
        for (int day = 2; day <= N; day++) {
            // Ways to have chocolate on 'day' is the sum of ways to have chocolate or ice-cream on 'day-1'
            choc[day] = choc[day - 1] + ice[day - 1];

            // Ways to have ice-cream on 'day' is the same as the ways to have chocolate on 'day-1'
            // (since ice-cream cannot be eaten on consecutive days)
            ice[day] = choc[day - 1];
        }

        // The total number of ways is the sum of ways to have chocolate or ice-cream on the last day
        System.out.print(choc[N] + ice[N]);
    }


}
