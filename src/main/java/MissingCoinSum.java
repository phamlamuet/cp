import java.util.Arrays;
import java.util.Scanner;

public class MissingCoinSum {
    /**
     * The key insight is that any subset of the given coins can form all sums from 0 up to the sum of all coins in the subset (inclusive).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        // Sort the coins in ascending order
        Arrays.sort(coins);

        // Initialize the smallest sum with 1
        long smallestSum = 1;

        // Iterate through the coins and update the smallestSum
        for (int i = 0; i < n; i++) {
            // If the current coin value is greater than the current smallest sum,
            // then we have found the smallest sum that cannot be created
            if (coins[i] > smallestSum) {
                break;
            }
            // Otherwise, update the smallest sum by adding the current coin value
            smallestSum += coins[i];
        }

        System.out.println(smallestSum);
    }
}
