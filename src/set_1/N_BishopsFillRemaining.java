package set_1;

import java.util.Scanner;

public class N_BishopsFillRemaining {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        byte board[][] = new byte[N][N];
        boolean swDiagonals[] = new boolean[2 * N - 1];
        boolean nwDiagonals[] = new boolean[2 * N - 1];
        boolean bishopRows[] = new boolean[N];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                board[row][col] = sc.nextByte();
                if (board[row][col] == 1) {
                    bishopRows[row] = true;
                }
            }
        }

        if (canPlace(N, 0, board, swDiagonals, nwDiagonals, bishopRows)) {
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    System.out.print(board[row][col] + " ");
                }
                System.out.println("");
            }
        } else {
            System.out.println("NotPossible");
        }
    }

    private static boolean canPlace(int N, int row, byte[][] board, boolean[] swDiagonals, boolean[] nwDiagonals, boolean[] bishopRows) {
        if (row == N) {
            return true;
        }
        if (bishopRows[row]) {
            return canPlace(N, row + 1, board, swDiagonals, nwDiagonals, bishopRows);
        }
        for (int col = 0; col < N; col++) {
            if (!swDiagonals[col - row + N - 1] && !nwDiagonals[row + col]) {
                board[row][col] = 1;
                bishopRows[row] = true;
                swDiagonals[col - row + N - 1] = true;
                nwDiagonals[row + col] = true;

                if (canPlace(N, row + 1, board, swDiagonals, nwDiagonals, bishopRows)) {
                    return true;
                }

                board[row][col] = 0;
                bishopRows[row] = false;
                swDiagonals[col - row + N - 1] = false;
                nwDiagonals[row + col] = false;
            }
        }
        return false;
    }
}
