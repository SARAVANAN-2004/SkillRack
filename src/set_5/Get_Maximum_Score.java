package set_5;
import java.util.*;

public class Get_Maximum_Score {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read the size of the first array
        int n1 = in.nextInt();
        int[] nums1 = new int[n1];

        // Read elements of the first array
        for (int i = 0; i < n1; i++) {
            nums1[i] = in.nextInt();
        }

        // Read the size of the second array
        int n2 = in.nextInt();
        int[] nums2 = new int[n2];

        // Read elements of the second array
        for (int i = 0; i < n2; i++) {
            nums2[i] = in.nextInt();
        }

        // Call the solve function and print the result
        System.out.println(maxSum(nums1, nums2));
    }


    public static int maxSum(int[] nums1, int[] nums2) {
        int i1 = 0, i2 = 0;
        long sum1 = 0, sum2 = 0;
        long maxScore = 0;
        int l1 = nums1.length, l2 = nums2.length;

        // Traverse both arrays simultaneously
        while (i1 < l1 && i2 < l2) {
            if (nums1[i1] == nums2[i2]) {
                // If elements are equal, take the max sum path and reset both
                maxScore += Math.max(sum1, sum2) + nums1[i1];
                sum1 = 0;
                sum2 = 0;
                i1++;
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                // Move forward in nums1 and accumulate sum1
                sum1 += nums1[i1++];
            } else {
                // Move forward in nums2 and accumulate sum2
                sum2 += nums2[i2++];
            }
        }

        // Process remaining elements in nums1
        while (i1 < l1) {
            sum1 += nums1[i1++];
        }

        // Process remaining elements in nums2
        while (i2 < l2) {
            sum2 += nums2[i2++];
        }

        // Add the maximum remaining sum to maxScore
        maxScore += Math.max(sum1, sum2);

        // Return result with modulo constraint
        return (int) (maxScore % 1000000007);
    }
}
