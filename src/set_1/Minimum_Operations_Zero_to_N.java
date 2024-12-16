package set_1;

import java.util.Scanner;

public class Minimum_Operations_Zero_to_N {
    public static void main(String[] args) {
        // Your Code Here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int cnt = 0;
        while (n > 0) {
            if ((n&1)==1) {
                n--;
            } else {
                n /= 2;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
