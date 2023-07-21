import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CoinPiles {
    void solve() throws IOException {
        Scanner scanner = new Scanner(System.in);
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int t = Integer.parseInt(bufferedReader.readLine());

        while (t-- > 0) {
            String[] input = bufferedReader.readLine().split(" ");
            long a = Long.parseLong(input[0]);
            long b = Long.parseLong(input[1]);

            if (a == 0 && b == 0) {
                System.out.println("YES");
                continue;
            } else if (a == 0 || b == 0) {
                System.out.println("NO");
                continue;
            }

            float max = Math.max(a, b);
            float min = Math.min(a, b);
            float d = max / min;
            if (d > 2.0f) {
                System.out.println("NO");
            } else if ((a + b) % 3 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CoinPiles problem = new CoinPiles();
        problem.solve();
    }
}
