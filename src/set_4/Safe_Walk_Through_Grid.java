package set_4;
import java.util.*;

public class Safe_Walk_Through_Grid {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read matrix dimensions and health
        int n = in.nextInt(), m = in.nextInt(), h = in.nextInt();
        int[][] arr = new int[n][m];

        // Read the grid input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        // Solve and print the result
        System.out.println(solve(arr, n, m, h));
    }

    public static boolean solve(int[][] arr, int n, int m, int h) {
        // If the health is already enough to reach the last column
        if(h >= n + m - 1) return true;

        // BFS queue to store {row, column, remaining health}
        Queue<int[]> que = new ArrayDeque<>();

        // Visited array to track (row, col, remaining health)
        boolean[][][] vis = new boolean[n][m][h+1];
        h -= arr[0][0]; // Deduct health at the starting point

        // If health is already 0, return false
        if(h < 0) return false;

        // Start BFS from (0,0) with the initial health
        que.add(new int[]{0, 0, h});

        // BFS traversal
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0], c = cur[1], h_rem = cur[2];

            // If reached the last column, return true
            if(r == n-1 && c == m-1) return true;

            // If already visited with this remaining health, continue
            if(vis[r][c][h_rem]) continue;
            vis[r][c][h_rem] = true;

            // Possible moves (down, up, right, left)
            int[] adjR = {1, -1, 0, 0};
            int[] adjC = {0, 0, 1, -1};

            for(int i = 0; i < 4; i++) {
                int row = r + adjR[i], col = c + adjC[i];

                // Check if within bounds and has enough health to move
                if(row >= 0 && row < n && col >= 0 && col < m && h_rem - arr[row][col] >= 1) {
                    que.add(new int[]{row, col, h_rem - arr[row][col]});
                }
            }
        }

        // If BFS ends without reaching the destination, return false
        return false;
    }

}
