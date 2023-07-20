import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://cses.fi/problemset/task/1070
 * Should be solve in C++, Java will be TLE
 * With Java should use PrintWriter
 */
public class Problem5 {

    void solve(){
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = scanner.nextInt();

        if (n == 1) {
            out.println("1");

        } else if (n <= 3) {
            out.println("NO SOLUTION");

        } else {
            if (n % 2 == 0) {  //if n is even
                for (int i = 2; i <= n; i += 2) {
                    out.print(i + " ");
                }
                for (int i = 1; i <= n; i += 2) {
                    out.print(i + " ");
                }
            } else { //n is odd
                for (int i = n - 1; i >= 1; i -= 2) {
                    out.print(i + " ");
                }
                for (int i = n; i >= 1; i -= 2) {
                    out.print(i + " ");
                }
            }
        }
        out.flush();
        out.close();
    }
    public static void main(String[] args) {
        Problem5 problem5 = new Problem5();
        problem5.solve();
    }
}
