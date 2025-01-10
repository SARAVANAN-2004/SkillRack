package set_3;
import java.util.*;

public class Intelligent_Chef {

   // Class to represent a food item and its associated customers
    static class FoodItem implements Comparable<FoodItem> {
        String name;                 // Name of the food item
        List<Integer> customer;      // List of customers who prefer this food item

        // Comparator to sort food items based on the number of customers (descending order)

        public int compareTo(FoodItem other) {
            return this.customer.size() - other.customer.size();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input the number of customers
        int n = in.nextInt();
        in.nextLine();  // Consume the remaining newline

        // List to keep track of remaining customers
        List<Integer> remainingCustomer = new ArrayList<>();

        // Map to store food items and their respective customers
        Map<String, FoodItem> map = new HashMap<>();

        // Populate data for customers and their preferences
        for (int cus = 1; cus <= n; cus++) {
            remainingCustomer.add(cus);  // Add each customer to the remaining list

            // Read the preferences for the current customer
            String[] preference = in.nextLine().split(" ");
            for (String s : preference) {
                // If food item is not already in the map, add it
                if (!map.containsKey(s)) {
                    FoodItem fi = new FoodItem();
                    fi.name = s;
                    fi.customer = new ArrayList<>();
                    map.put(s, fi);
                }
                // Add the current customer to the food item's customer list
                map.get(s).customer.add(cus);
            }
        }

        int cnt = 0;  // Counter to track the number of rounds

        // While there are still remaining customers
        while (!remainingCustomer.isEmpty()) {
            // Create a list of food items and sort them by the number of customers
            List<FoodItem> item = new ArrayList<>(map.values());
            Collections.sort(item, Collections.reverseOrder());  // Sort in descending order

            // Select the food item with the most customers
            FoodItem mostPreferred = item.get(0);

            // Remove all customers who chose this food item
            remainingCustomer.removeAll(mostPreferred.customer);

            // Remove the most preferred food item from the map
            map.remove(mostPreferred.name);

            // Update other food items by removing customers who have been served
            for (String s : map.keySet()) {
                map.get(s).customer.removeAll(mostPreferred.customer);
            }

            cnt++;  // Increment the round count
        }

        // Output the total number of rounds
        System.out.println(cnt);
    }
}
