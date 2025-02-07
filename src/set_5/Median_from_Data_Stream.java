package set_5;
import java.util.*; // Importing required utilities

public class Median_from_Data_Stream {

    // Two heaps (priority queues) for median finding
    static PriorityQueue<Integer> left;  // Max-heap (stores smaller half)
    static PriorityQueue<Integer> right; // Min-heap (stores larger half)

    public static void main(String[] args) {
        // Scanner for user input
        Scanner in = new Scanner(System.in);

        // Reading number of elements
        int n = in.nextInt();

        // Array to store input numbers
        int[] arr = new int[n];

        // Reading input values
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        // Initializing the two heaps
        right = new PriorityQueue<>(); // Min-heap (default behavior)
        left = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap (to store smaller values)

        // Processing each element
        for(int i : arr){
            if(i <= 0){
                // If the number is non-positive, print current median
                System.out.print(getMedian() + " ");
            } else {
                // Otherwise, add the number to the heaps
                add(i);
            }
        }
    }

    // Function to add a number into the heaps
    public static void add(int n){
        if(left.size() == right.size()) {
            // If both heaps are of the same size, insert into right heap
            right.offer(n);
            left.offer(right.poll()); // Balance the heaps
        } else {
            // If heaps are imbalanced, insert into left heap
            left.offer(n);
            right.offer(left.poll()); // Balance the heaps
        }
    }

    // Function to get the median of the current numbers
    public static double getMedian(){
        if((left.size() + right.size()) % 2 == 0) {
            // If total count is even, return average of middle two elements
            return ((left.peek() + right.peek()) / 2.0);
        }
        // If odd, return the top of max-heap (left heap)
        return left.peek();
    }
}
