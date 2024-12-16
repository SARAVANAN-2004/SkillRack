package set_1;

import java.util.Scanner;

public class Social_Media_Leader {
    public static void main(String[] args) {
        // Your Code Here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // Number of people

        int relation = in.nextInt(); // Number of follower-followed relationships

        // The gang leader has n-1 followers
        int[] arr = new int[n + 1];

        // Process each follower-followed relationship
        for (int i = 0; i < relation; i++) {
            int followedBy = in.nextInt(); // Person who follows
            int followed = in.nextInt();   // Person being followed

            arr[followedBy]--; // Decrement count for the follower
            arr[followed]++;    // Increment count for the person being followed
        }

        // Find the gang leader (has n-1 followers)
        for (int i = 1; i <= n; i++) {
            if (arr[i] == n - 1) {
                System.out.println(i); // Print the gang leader's index
                return;
            }
        }

        // If no gang leader is found
        System.out.println(-1);
    }
}
