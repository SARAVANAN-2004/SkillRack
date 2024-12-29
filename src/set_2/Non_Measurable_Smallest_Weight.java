package set_2;
import java.util.*;

public class Non_Measurable_Smallest_Weight {

    public static void main(String[] args) {
        // Your Code Here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum < arr[i] - 1) {
                System.out.println(sum + 1);
                return;
            }
            sum += arr[i];
        }
        System.out.println(sum + 1);
    }
}
