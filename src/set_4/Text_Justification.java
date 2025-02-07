package set_4;
import java.util.*;

public class Text_Justification {


    public static void main(String[] args) {
        // Your Code Here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int maxWidth = in.nextInt();
        List<String> word = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = in.next();
            word.add(s);
        }
        List<String> res = solve(word, maxWidth);
        for (String s : res) {
            System.out.println(s);
        }
    }

    public static List<String> solve(List<String> word, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int curWidth = 0, len = 0;
        for (String s : word) {
            int curLen = s.length();
            if (curWidth + curLen > maxWidth) {
                process(res, ans, len, maxWidth);
                curWidth = 0;
                len = 0;
                ans.clear();
            }
            ans.add(s);
            curWidth += s.length() + 1;
            len += s.length();
        }
        lastLine(res, ans, maxWidth);
        return res;
    }

    public static void lastLine(List<String> res, List<String> ans, int maxWidth) {
        StringBuilder temp = new StringBuilder();
        for (String s : ans) {
            temp.append(s);
            if (temp.length() < maxWidth) {
                temp.append("_");
            }
        }
        while (temp.length() < maxWidth) {
            temp.append("_");
        }
        res.add(temp.toString());
    }

    public static void process(List<String> res, List<String> ans, int len, int maxWidth) {
        StringBuilder temp = new StringBuilder();
        int space = ans.size() - 1;
        int minSpace = maxWidth - len;
        int extraSpace = maxWidth - len;
        int maxSpace = 0;
        if (space != 0) {
            minSpace = extraSpace / space;
            maxSpace = extraSpace % space;
        }

        String underScore = "";
        for (int i = 0; i < minSpace; i++) {
            underScore += "_";
        }

        for (String s : ans) {
            temp.append(s);
            if (temp.length() < maxWidth) {
                temp.append(underScore);
                if (maxSpace > 0) {
                    temp.append("-");
                    maxSpace--;
                }
            }
        }
        res.add(temp.toString());
    }
}
