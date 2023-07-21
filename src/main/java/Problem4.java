import java.util.Scanner;

public class Problem4 {
    int n;
    int[] arr;

    long solve() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        if (n < 2) {
            return 0;
        }

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        long totalNeedToAdd = 0;

        for (int i = 1; i < arr.length; i++) {
            int needToAdd = arr[i - 1] - arr[i];
            if (needToAdd <= 0) {
                continue;
            } else {
                totalNeedToAdd += needToAdd;
                //update current element
                arr[i] += needToAdd;
            }
        }

        return totalNeedToAdd;
    }

    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        System.out.println(problem4.solve());

    }
}
