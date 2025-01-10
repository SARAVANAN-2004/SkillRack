package set_3;
import java.util.*;

public class Toll_Gate_Collection {

 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Total length of the highway (N) and minimum distance between toll gates (D)
        int highwayLength = scanner.nextInt();
        int minDistance = scanner.nextInt() + 1;

        // Input: Number of toll gates (K)
        int tollCount = scanner.nextInt();

        // Input: Distances of toll gates from the starting point
        int[] tollDistances = new int[tollCount];
        for (int i = 0; i < tollCount; i++) {
            tollDistances[i] = scanner.nextInt();
        }

        // Input: Revenue collected at each toll gate
        int[] tollRevenues = new int[tollCount];
        for (int i = 0; i < tollCount; i++) {
            tollRevenues[i] = scanner.nextInt();
        }

        // DP array to store maximum revenue up to each kilometer
        int[] maxRevenue = new int[highwayLength + 1];
        int tollIndex = 0;

        // Iterate through each kilometer of the highway
        for (int km = 1; km <= highwayLength; km++) {
            // If the current kilometer does not match the next toll gate
            if (tollIndex >= tollCount || km < tollDistances[tollIndex]) {
                maxRevenue[km] = maxRevenue[km - 1];
            } else {
                // Calculate maximum revenue considering the toll gate
                maxRevenue[km] = Math.max(
                        maxRevenue[km - 1],
                        maxRevenue[Math.max(0, km - minDistance)] + tollRevenues[tollIndex]
                );
                tollIndex++; // Move to the next toll gate
            }
        }

        // Output the maximum revenue that can be collected from start to end
        System.out.println(maxRevenue[highwayLength]);
    }
}
