package set_5;
import java.util.*;

// Worker class implements Comparable to sort by wage-to-quality ratio
class Worker implements Comparable<Worker> {
    int q;      // Quality of the worker
    double wqr; // Wage-to-quality ratio

    // Constructor to initialize worker's quality and wage-to-quality ratio
    public Worker(int q, double wqr) {
        this.q = q;
        this.wqr = wqr;
    }

    // Compare workers based on wage-to-quality ratio
    public int compareTo(Worker other) {
        return Double.compare(this.wqr, other.wqr);
    }
}
public class Minimum_Cost_Hire_Workers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // Number of workers
        int k = in.nextInt(); // Number of workers to hire

        ArrayList<Worker> arr = new ArrayList<>();

        // Read workers' quality and wage and calculate their wage-to-quality ratio
        for (int i = 0; i < n; i++) {
            int q = in.nextInt();     // Worker quality
            int wage = in.nextInt();  // Worker wage
            arr.add(new Worker(q, (double) wage / q)); // Store worker details
        }

        // Sort workers by wage-to-quality ratio (ascending order)
        Collections.sort(arr);

        // Max heap (priority queue) to maintain top k quality workers
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        double minWage = Double.MAX_VALUE; // Store the minimum possible wage cost
        long total = 0; // Maintain sum of quality of selected workers

        // Process each worker
        for (Worker w : arr) {
            total += w.q;    // Add worker's quality to total
            pq.add(w.q);     // Add quality to priority queue

            // If we have more than k workers, remove the one with highest quality
            if (pq.size() > k) {
                total -= pq.poll();
            }

            // When exactly k workers are selected, compute the minimum wage
            if (pq.size() == k) {
                double curCost = total * w.wqr; // Compute total wage cost
                minWage = Math.min(curCost, minWage); // Update minimum wage if needed
            }
        }

        // Print the minimum wage required to hire k workers with 5 decimal precision
        System.out.printf("%.5f", minWage);
    }
}
