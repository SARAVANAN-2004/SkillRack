import java.util.*;
public class Arrays_Majority_Element {
        public static void main(String[] args) {
            // print the element occuring more than n/2 times in the array
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int maj = arr[0], cnt = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i] == maj) {
                    cnt++;
                } else {
                    cnt--;
                    if (cnt == 0) {
                        maj = arr[i];
                        cnt++;
                    }
                }
            }
            if (cnt > 0) {
                int maj_cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (arr[i] == maj) {
                        maj_cnt++;
                    }
                }
                if (maj_cnt > (n / 2)) {
                    System.out.println(maj);
                    return;
                }
            }
            System.out.println("No Majority Element");

        }

}
