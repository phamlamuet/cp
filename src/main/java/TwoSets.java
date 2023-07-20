import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TwoSets {
    void solve() {
        //two sets problem solution
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        int n = scanner.nextInt();
        long sum = (long) n * (n + 1) / 2;
        long halfSum = sum / 2;
        if (sum % 2 != 0) {
            System.out.println("NO");
            return;
        } else {
            printWriter.println("YES");
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            long sum1 = 0;

            for (int i = n; i >= 1; i--) {
                if (sum1 + i <= halfSum) {
                    sum1 += i;
                    set1.add(i);
                } else {
                    set2.add(i);
                }
            }

            printWriter.println(set1.size());
            for (long i : set1) {
                printWriter.print(i + " ");
            }
            printWriter.println("");
            printWriter.println(set2.size());
            for (long i : set2) {
                printWriter.print(i + " ");
            }
        }
        printWriter.flush();
        printWriter.close();
    }

    public static void main(String[] args) {
        TwoSets twoSets = new TwoSets();
        twoSets.solve();
    }
}
