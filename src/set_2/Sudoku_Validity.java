package set_2;
import java.util.*;

public class Sudoku_Validity {

    public static void main(String[] args) {
        // Your Code Here
        Scanner in = new Scanner(System.in);

        int[] rflag = new int[9];
        int[] cflag = new int[9];
        int[] smflag = new int[9];

        Arrays.fill(rflag, 1);
        Arrays.fill(cflag, 1);
        Arrays.fill(smflag, 1);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int digit = in.nextInt();

                rflag[row] |= (1 << digit);
                cflag[col] |= (1 << digit);
                smflag[(row / 3) * 3 + (col / 3)] |= (1 << digit);
            }
        }

        int val = (1 << 10) - 1;
        for (int i = 0; i < 9; i++) {
            if (rflag[i] != val || cflag[i] != val || smflag[i] != val) {
                System.out.println("INVALID");
                return;
            }
        }
        /*
        for each row, col, submatrix it takes or and calculates the value
         */

        System.out.println("VALID");
    }
}