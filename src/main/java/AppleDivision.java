import java.util.Scanner;
import java.util.Arrays;

public class AppleDivision{
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        findMinDifference(weights, 0, 0, 0);
        System.out.println(minDifference);
    }

    // Recursive function to find the minimum difference between two groups
    //this is a copied solution and way too hard to understand, so I created a V2 solution
    public static void findMinDifference(int[] weights, int idx, int group1Sum, int group2Sum) {
        if (idx == weights.length) {
            int difference = Math.abs(group1Sum - group2Sum);
            minDifference = Math.min(minDifference, difference);
            return;
        }

        // Add the current apple to group 1 and explore further
        findMinDifference(weights, idx + 1, group1Sum + weights[idx], group2Sum);

        // Add the current apple to group 2 and explore further
        findMinDifference(weights, idx + 1, group1Sum, group2Sum + weights[idx]);
    }
}
