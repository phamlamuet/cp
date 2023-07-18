import java.util.Scanner;

public class Problem1 {
    long n;

    void solve() {
        System.out.print(n + " ");
        while (n!=1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        Scanner scanner = new Scanner(System.in);
        problem1.n = scanner.nextInt();
        problem1.solve();
    }
}