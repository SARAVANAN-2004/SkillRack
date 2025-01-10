package set_3;
import java.util.*;

public class Vendor_Maximum_Profit {

    public static void main(String[] args) {
        // Input Scanner
        Scanner scanner = new Scanner(System.in);

        // Total budget N and number of items K
        int totalBudget = scanner.nextInt();
        int numberOfItems = scanner.nextInt();

        // List to store the cost price and profit of each item
        List<int[]> items = new ArrayList<>();

        // Reading the cost price and profit for each item
        for (int i = 0; i < numberOfItems; i++) {
            int[] item = new int[2];
            item[0] = scanner.nextInt(); // Cost price of the item
            item[1] = scanner.nextInt(); // Profit of the item
            items.add(item);
        }

        // Sort the items based on cost price in ascending order
        Collections.sort(items, (item1, item2) -> item1[0] - item2[0]);

        // DP table to store maximum profit for given budget
        int[][] dp = new int[numberOfItems + 1][totalBudget + 1];

        // Variable to keep track of the maximum profit
        int maxProfit = 0;

        // Fill the DP table
        for (int itemIndex = 1; itemIndex <= numberOfItems; itemIndex++) {
            int[] currentItem = items.get(itemIndex - 1);
            int costPrice = currentItem[0];
            int profit = currentItem[1];

            for (int currentBudget = 1; currentBudget <= totalBudget; currentBudget++) {
                if (currentBudget < costPrice) {
                    // If current budget is less than item's cost price, carry forward the previous profit
                    dp[itemIndex][currentBudget] = dp[itemIndex - 1][currentBudget];
                } else {
                    // Calculate the maximum profit by including or excluding the current item
                    dp[itemIndex][currentBudget] = Math.max(
                            dp[itemIndex - 1][currentBudget],
                            dp[itemIndex - 1][currentBudget - costPrice] + profit
                    );
                }
                // Update the maximum profit
                maxProfit = Math.max(maxProfit, dp[itemIndex][currentBudget]);
            }
        }

        // Output the maximum profit
        System.out.println(maxProfit);
    }
}
