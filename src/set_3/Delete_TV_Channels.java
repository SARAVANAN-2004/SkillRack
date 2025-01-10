package set_3;
import java.util.*;

public class Delete_TV_Channels {

    public static void main(String[] args) {
        // Input handling
        Scanner scanner = new Scanner(System.in);

        // Number of channels (N) and step size (K)
        int totalChannels = scanner.nextInt(); // N
        int stepSize = scanner.nextInt(); // K

        // List to represent the channels
        List<Integer> channels = new ArrayList<>();

        // Add channels (1 to N) to the list
        for (int channel = 1; channel <= totalChannels; channel++) {
            channels.add(channel);
        }

        // Initialize the starting index
        int currentIndex = stepSize - 1;

        // Repeat until only one channel is left
        while (channels.size() > 1) {
            // Remove the channel at the current index
            channels.remove(currentIndex);

            // Update the size of the channel list
            int remainingChannels = channels.size();

            // Move the currentIndex one step back
            currentIndex--;

            // If the index goes out of bounds, wrap it around to the last channel
            if (currentIndex == -1) {
                currentIndex = remainingChannels - 1;
            }

            // Move K steps forward
            currentIndex += stepSize;

            // Use modulo to wrap around the index within bounds
            currentIndex %= remainingChannels;
        }

        // Output the last remaining channel
        System.out.println(channels.get(0));
    }
}

