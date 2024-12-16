import java.util.Scanner;
import java.util.Stack;

public class ArrayNextGreaterElement {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Read the size of the array
        int[] arr = new int[N]; // Create an array to store the input elements

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt(); // Read the elements of the array
        }

        Stack<Integer> stack = new Stack<>(); // Create a stack to store elements

        for (int i = arr.length - 1; i >= 0; i--) { // Iterate the array in reverse order
            if (stack.isEmpty()) { // If stack is empty, push the current element
                stack.push(arr[i]);
            } else if (stack.peek() > arr[i]) { // If the top of the stack is greater, update the current element
                int greater = stack.peek();
                stack.push(arr[i]);
                arr[i] = greater;
            } else { // If the top of the stack is less than or equal to the current element
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop(); // Remove elements from the stack until a greater element is found
                }
                if (stack.isEmpty()) { // If no greater element is found, push the current element
                    stack.push(arr[i]);
                } else { // Update the current element with the greater element
                    int greater = stack.peek();
                    stack.push(arr[i]);
                    arr[i] = greater;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " "); // Print the next greater elements
        }
    }
}