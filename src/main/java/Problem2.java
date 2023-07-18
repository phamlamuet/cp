import java.util.Scanner;

public class Problem2 {
    long n;

    void solve() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        long missingSum = 0l;
        long fullSum = n * (n + 1) / 2;

        long k;
        for (int i = 0; i < n-1; i++) {
            k = scanner.nextInt();
            missingSum += k;
        }
        System.out.println(fullSum - missingSum);
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        problem2.solve();
    }
}