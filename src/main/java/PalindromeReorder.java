import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PalindromeReorder {

    void solve() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        PrintWriter printWriter = new PrintWriter(System.out);
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;

        StringBuilder ans = new StringBuilder();
        StringBuilder oddLengthString = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (value % 2 != 0) {
                count++;
                if (count > 1) {
                    System.out.println("NO SOLUTION");
                    return;
                }
                for (int i = 1; i <= value; i++) {
                    oddLengthString.append(key);
                }
                continue;
            }


            StringBuilder prefix = new StringBuilder();
            prefix.append(String.valueOf(key).repeat(Math.max(0, value / 2)));
            ans.append(prefix);
        }
       // ans.append(oddLengthString).append(ans.reverse());
        StringBuilder postfix = new StringBuilder(ans);
        postfix.reverse();
        ans.append(oddLengthString).append(postfix);
        printWriter.println(ans);
        printWriter.flush();
        printWriter.close();
    }

    public static void main(String[] args) {
        new PalindromeReorder().solve();
    }
}
