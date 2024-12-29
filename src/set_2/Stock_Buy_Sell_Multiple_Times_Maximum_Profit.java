package set_2;
import java.util.*;

public class Stock_Buy_Sell_Multiple_Times_Maximum_Profit {


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

            // Initialize the profit to 0
            int profit = 0;

            // Iterate through the array of stock prices
            for (int i = 1; i < n; i++) {
                // If the current stock price is greater than the previous stock price, add the difference to the profit
                if (arr[i] > arr[i - 1]) {
                    profit += arr[i] - arr[i - 1];
                }
            }

            // Print the total profit
            System.out.println(profit);
        }
    }
