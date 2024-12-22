package set_1;

import java.util.Scanner;

public class NRooksFillingsRows {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        byte[][] board = new byte[N][N];
        boolean[] rookRows = new boolean[N];
        boolean[] rookCols = new boolean[N];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                board[row][col] = in.nextByte();
                if (board[row][col] == 1) {
                    rookRows[row] = true;
                    rookCols[col] = true;
                }
            }
        }

        if (canPlace(N, 0,  board, rookRows, rookCols)) {
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    System.out.print(board[row][col] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.print("NotPossible");
        }
    }

    private static boolean canPlace(int N, int row, byte[][] board, boolean[] rookRows, boolean[] rookCols) {
        if (row == N) {
            return true;
        }

        if (rookRows[row]) {
            return canPlace(N, row + 1, board, rookRows, rookCols);
        }

        for (int col = 0; col < N; col++) {
            if (!rookCols[col]) {
                board[row][col] = 1;
                rookRows[row] = true;
                rookCols[col] = true;
                if (canPlace(N, row + 1, board, rookRows, rookCols)) {
                    return true;
                } else {
                    board[row][col] = 0;
                    rookRows[row] = false;
                    rookCols[col]  = false;
                }
            }
        }
        return false;
    }
}
