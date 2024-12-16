package set_1;

import java.util.*;

public class RemoveAdjacentEqualValues {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // Read the number of elements
        int[] arr = new int[n]; // Create an array to store the input elements

        // Read input elements into the array
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Stack<Integer> stack = new Stack<>(); // Create a stack to store unique elements

        // Iterate through the array in reverse order
        for (int idx = n - 1; idx >= 0; idx--) {
            // If the stack is not empty and the top element is equal to the current element,
            // it means the current element appears at least twice, so remove it from the stack
            if (!stack.isEmpty() && stack.peek() == arr[idx]) {
                stack.pop();
            } else {
                // If the stack is empty or the top element is different, push the current element onto the stack
                stack.push(arr[idx]);
            }
        }

        // If the stack is empty, it means all elements appear at least twice
        if (stack.isEmpty()) {
            System.out.println(-1);
        } else {
            // Print the unique elements from the stack
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }
    }
}