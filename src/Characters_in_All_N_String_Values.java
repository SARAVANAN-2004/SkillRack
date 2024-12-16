import java.util.Scanner;

public class Characters_in_All_N_String_Values {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] asciicount = new int[128];
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = in.next();
            for (int j = 0; j < arr[i].length(); j++) {
                char ch = arr[i].charAt(j);
                if (asciicount[ch] == i) {
                    asciicount[ch]++;
                }
            }
        }

        for (int i = 0; i < 128; i++) {
            if (asciicount[i] == N) {
                System.out.print((char) i);
            }
        }

    }
}
