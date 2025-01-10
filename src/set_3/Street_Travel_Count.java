package set_3;
import java.util.*;

public class Street_Travel_Count {

    public static void main(String[] args) {
        //Your Code Here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        Queue<Integer> que = new LinkedList<>();
        int source = in.nextInt() * n + in.nextInt();
        int destination = in.nextInt() * n + in.nextInt();
        int[] streets = new int[n * n];
        boolean[] vis = new boolean[n * n];
        que.add(source);
        vis[source] = true;

        while (!que.isEmpty()) {
            int node = que.poll();
            List<Integer> relateNode = getRelatedNode(arr, n, node);

            for (int rel : relateNode) {
                if (!vis[rel]) {
                    vis[rel] = true;
                    streets[rel] = streets[node] + 1;
                    que.add(rel);
                    if (rel == destination) {
                        System.out.println(streets[rel]);
                        return;
                    }
                }
            }
        }
        System.out.println(streets[destination]);
    }

    public static List<Integer> getRelatedNode(int[][] arr, int n, int node) {
        List<Integer> related = new ArrayList<>();
        int row = node / n;
        int col = node % n;

        for (int c = col - 1; c >= 0; c--) {
            if (arr[row][c] == 1) {
                related.add(row * n + c);
            } else {
                break;
            }
        }

        for (int c = col + 1; c < n; c++) {
            if (arr[row][c] == 1) {
                related.add(row * n + c);
            } else {
                break;
            }
        }

        for (int r = row - 1; r >= 0; r--) {
            if (arr[r][col] == 1) {
                related.add(r * n + col);
            } else {
                break;
            }
        }

        for (int r = row + 1; r < n; r++) {
            if (arr[r][col] == 1) {
                related.add(r * n + col);
            } else {
                break;
            }
        }

        return related;
    }
}
