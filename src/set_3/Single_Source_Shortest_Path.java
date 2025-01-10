package set_3;
import java.util.*;  // Import Java utility package for Scanner and List

public class Single_Source_Shortest_Path {

    // Class to represent a link between two nodes with source, destination, and distance
    public static class Link {
        int source, dest, dist;
    }

    public static void main(String[] args) {
        // Scanner to read input
        Scanner in = new Scanner(System.in);

        // n = number of nodes, l = number of links (edges)
        int n = in.nextInt(), l = in.nextInt();

        // List to store all links (edges) in the graph
        List<Link> Links = new ArrayList<>();

        // Reading l edges and storing them in the Links list
        for (int i = 0; i < l; i++) {
            Link link = new Link();
            link.source = in.nextInt();  // Source node
            link.dest = in.nextInt();    // Destination node
            link.dist = in.nextInt();    // Distance or weight of the edge
            Links.add(link);             // Add the link to the list
        }

        // Array to store the shortest distance from the source node (1) to each node
        Integer[] shortest = new Integer[n + 1];
        shortest[1] = 0;  // Distance to the source node itself is 0

        // Flag to check if relaxation occurs during an iteration
        boolean relaxation = true;

        // Relaxation loop for Bellman-Ford algorithm (n-1 times)
        for (int itr = 1; itr < n - 1 && relaxation; itr++) {
            relaxation = false;  // Reset relaxation for this iteration

            // Iterate over each link to perform relaxation
            for (Link link : Links) {

                // Skip if the source node's shortest distance is not yet calculated
                if (shortest[link.source] == null) {
                    continue;
                }

                // Relax the edge if:
                // 1. The destination node's distance is not yet calculated (null)
                // 2. A shorter path to the destination is found
                if (shortest[link.dest] == null ||
                        shortest[link.source] + link.dist < shortest[link.dest]) {

                    // Update the shortest distance to the destination node
                    shortest[link.dest] = shortest[link.source] + link.dist;

                    // Set relaxation to true to indicate a change was made
                    relaxation = true;
                }
            }
        }

        // Print the shortest distances from node 1 to all other nodes
        for (int i = 2; i <= n; i++) {
            System.out.print(shortest[i] + " ");
        }
    }
}
