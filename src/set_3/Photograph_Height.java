package set_3;
import java.util.*;  // Import utility classes (like Scanner, Queue, etc.)

public class Photograph_Height {

    public static void main(String[] args) {
        // Scanner to read input from the console
        Scanner in = new Scanner(System.in);

        // Read first line, split by comma, and parse n and k
        String[] first = in.nextLine().split(",");
        int n = Integer.parseInt(first[0].trim()); // Total number of characters
        int k = Integer.parseInt(first[1].trim()); // Number of photo sequences

        // Create a string of characters from A to the nth letter of the alphabet
        String names = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(0, n);

        // List to store photo sequences
        List<String> photos = new ArrayList<>();

        // Read k lines of photo sequences
        for(int ctr = 1; ctr <= k; ctr++) {
            photos.add(in.nextLine().trim().replaceAll(",", "")); // Remove commas from input
        }

        // Flag to check if any missing characters are found
        boolean missing = true;
//        System.out.println(photos);

        // Loop through each character in the names string
        for(Character name : names.toCharArray()) {
            // Initialize a queue for BFS and a list to track visited characters
            Queue<Character> queue = new ArrayDeque<>();
            List<Character> visited = new ArrayList<>();

            // Start BFS with the current character
            queue.add(name);
            visited.add(name);
            int relcnt = 0;  // Counter to track reachable nodes

            // Perform BFS to find reachable nodes
            while(!queue.isEmpty()) {
                Character student = queue.poll();  // Dequeue the next node

                // Check each photo sequence for successors of the current node
                for(String seq : photos) {
                    if(seq.contains(student.toString())) {
//                        System.out.println("contain " + seq + " "+student);
                        // Extract substring from the point where the student appears
                        String successor = seq.substring(seq.indexOf(student)+1);
//                        System.out.println("succesor of "+name +" "+ seq+" "+successor);
                        // Add each successor character to the queue if not visited
                        for(Character succ : successor.toCharArray()) {
                            if(!visited.contains(succ)) {
                                queue.add(succ);
                                relcnt++;  // Increment reachable count
                                visited.add(succ);
                            }
                        }
                    }
                }
            }

            // Perform reverse BFS to find predecessors
            queue.add(name);
            while(!queue.isEmpty()) {
                Character student = queue.poll();
                for(String seq : photos) {
                    if(seq.contains(student.toString())) {
                        String pre = seq.substring(0, seq.indexOf(student));
                        for(Character pred : pre.toCharArray()) {
                            if(!visited.contains(pred)) {
                                queue.add(pred);
                                relcnt++;
                                visited.add(pred);
                            }
                        }
                    }
                }
            }

            // If not all nodes are reachable, print the character and update the flag
            if(relcnt != n - 1) {
                System.out.print(name + " ");
                missing = false;
            }
        }

        // If no missing characters are found, print "N/A"
        if(missing) {
            System.out.println("N/A");
        }
    }
}
