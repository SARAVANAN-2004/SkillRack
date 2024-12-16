import java.util.Scanner;

public class Minimum_Operations_X_to_Y {
    public static void main(String[] args) {
        // Your Code Here
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();

        int cnt = 0;

        // Loop until y becomes equal to x
        while (y != x) {
            // If y is less than x or y is odd, increment y
            if (y < x || y % 2 == 1) {
                y++;
            } else {
                // Otherwise, divide y by 2
                y /= 2;
            }
            cnt++; // Increment the counter in each iteration
        }

        System.out.println(cnt);
    }
}
