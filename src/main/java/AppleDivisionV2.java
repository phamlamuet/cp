import java.util.Scanner;

public class AppleDivisionV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] weights = new long[n];

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextLong();
        }

        long minDifference = findMinDifference(weights);
        System.out.println(minDifference);
    }

    public static long findMinDifference(long[] weights) {
        int n = weights.length;
        long min = Long.MAX_VALUE;
        long totalWeight = 0L;
        for (int i = 0; i < n; i++) {
            totalWeight += weights[i];
        }

        for (long mask = 0; mask < (1 << n); mask++) { //iterate through all the possible bitmasks
            long subsetSum = 0;
            for (int i = 0; i < n; i++) {              // for each bitmask add the 1s to the subSum
                if ((mask & (1 << i)) != 0) {
                    subsetSum += weights[i];
                }
            }
            //calculate the min and update the min value
            min = Math.min(min, Math.abs(totalWeight - 2 * subsetSum));
        }
        return min;
    }
}
