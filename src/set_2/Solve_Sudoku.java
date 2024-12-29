package set_2;
import java.util.*;

public class Solve_Sudoku {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int[][] matrix = new int[9][9];
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    matrix[r][c] = in.nextInt();
                }
            }

            if (solve(matrix)) {
                for (int r = 0; r < 9; r++) {
                    for (int c = 0; c < 9; c++) {
                        System.out.print(matrix[r][c] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Not Solved");
            }
        }

        public static boolean solve(int[][] matrix) {
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    if (matrix[r][c] == 0) {
                        for (int d = 1; d <= 9; d++) {
                            if (isvalid(matrix, r, c, d)) {
                                matrix[r][c] = d;
                                if (solve(matrix)) {
                                    return true;
                                }
                                matrix[r][c] = 0;
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        public static boolean isvalid(int[][] matrix, int row, int col, int digit) {
            for (int i = 0; i < 9; i++) {
                if (matrix[row][i] == digit) {
                    return false;
                }
                if (matrix[i][col] == digit) {
                    return false;
                }
                if (matrix[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == digit) {
                    return false;
                }
            }
            return true;
        }
}
