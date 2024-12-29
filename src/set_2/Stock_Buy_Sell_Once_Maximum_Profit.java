package set_2;
import java.util.*;

public class Stock_Buy_Sell_Once_Maximum_Profit {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner in = new Scanner(System.in);

        // Read the number of stock prices
        int n = in.nextInt();

        // Create an array to store the stock prices
        int[] arr = new int[n];

        // Read the stock prices from the user
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // Initialize the minimum stock price
        int minStock = arr[0];

        // Calculate the maximum profit
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            // Update the maximum profit if the current stock price is higher than the minimum stock price
            maxProfit = Math.max(maxProfit, arr[i] - minStock);

            // Update the minimum stock price if the current stock price is lower
            minStock = Math.min(minStock, arr[i]);
        }

        // Print the maximum profit
        System.out.println(maxProfit);
    }
}