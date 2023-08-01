import java.util.Scanner;

public class MaximumSubarraySum {
    long solve() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            int k = input.nextInt();
            arr[i] = k;
        }
        long sum = 0;
        long max = -Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > 0) {
                sum += arr[i];
                if (sum > max) {
                    max = sum;
                }
            } else {
                sum = 0;
                max = Math.max(max, arr[i]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarraySum().solve());
    }
}
