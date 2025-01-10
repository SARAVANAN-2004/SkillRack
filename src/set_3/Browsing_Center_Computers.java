package set_3;
import java.util.*;

public class Browsing_Center_Computers {

    public static void main(String[] args) {
        // Initialize Scanner to read input
        Scanner in = new Scanner(System.in);

        // Read the number of customer slots
        int N = in.nextInt();

        // Create lists to store start and end times in minutes
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();

        // Read the newline character after the integer input
        in.nextLine();

        // Read the start and end times of each slot
        for (int i = 0; i < N; i++) {
            String[] slot = in.nextLine().split(" ");

            // Convert and store the start and end times in minutes
            startTimes.add(convertToMinutes(slot[0]));
            endTimes.add(convertToMinutes(slot[1]));
        }

        // Sort the start and end times
        Collections.sort(startTimes);
        Collections.sort(endTimes);

        // Initialize pointers and variables
        int startPtr = 0, endPtr = 0, minComputers = 0;

        // Calculate the required computers
        while (startPtr < N && endPtr < N) {
            int currentComputers = Math.abs(startPtr - endPtr) + 1;

            // Update the maximum number of computers required
            minComputers = Math.max(currentComputers, minComputers);

            // If a new customer starts browsing
            if (startTimes.get(startPtr) < endTimes.get(endPtr)) {
                startPtr++;  // Move to the next start time
            } else {
                endPtr++;  // Otherwise, free up a computer by moving to the next end time
            }
            while(startPtr < N && endPtr < N && startTimes.get(startPtr) >= endTimes.get(endPtr)){
                endPtr++;
            }
        }

        // Print the minimum number of computers required
        System.out.println(minComputers);
    }

    // Helper function to convert time (HH:mm) to total minutes
    public static int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }
}
