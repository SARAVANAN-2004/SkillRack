package set_4;
import java.util.*;

public class Binary_Matrix_Row_Duplicates {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        Set<String> set = new HashSet<>();
        boolean valid = true;

        for (int r = 0; r < row; r++) {
            StringBuilder s = new StringBuilder();
            for (int c = 0; c < col; c++) {
                int x = in.nextInt();
                s.append(" " + x);
            }

            if (set.contains(s.toString())) {
                System.out.print((r + 1) + " ");
                valid = false;
            }
            set.add(s.toString());
        }

        System.out.println(valid ? -1 : "");
    }
}


