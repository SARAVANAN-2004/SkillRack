package set_1;

import java.util.Scanner;

public class NBishopFillingRows {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        byte[][] board = new byte[N][N];
        boolean[] swd = new boolean[2 * N - 1];
        boolean[] nwd = new boolean[2 * N - 1];
        boolean[] bishop = new boolean[N];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                board[row][col] = in.nextByte();
                if (board[row][col] == 1) {
                    bishop[row] = true;
                    nwd[col + row] = true;
                    swd[col - row + N - 1] = true;
                }
            }
        }

        if (canPlace(N, 0, board, swd, nwd, bishop)) {
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    System.out.print(board[row][col] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("NotPossible");
        }
    }

    private static boolean canPlace(int N, int row, byte[][] board, boolean[] swd, boolean[] nwd, boolean[] bishop) {
        if (row == N) {
            return true;
        }
        if (bishop[row]) {
            return canPlace(N, row + 1, board, swd, nwd, bishop);
        }
        for (int col = 0; col < N; col++) {
            if (!swd[col - row + N - 1] && !nwd[col + row]) {
                board[row][col] = 1;
                bishop[row] = true;
                swd[col - row + N - 1] = true;
                nwd[col + row] = true;

                if (canPlace(N, row + 1, board, swd, nwd, bishop)) {
                    return true;
                } else {
                    board[row][col] = 0;
                    bishop[row] = false;
                    swd[col - row + N - 1] = false;
                    nwd[col + row] = false;
                }
            }
        }
        return false;
    }
}
