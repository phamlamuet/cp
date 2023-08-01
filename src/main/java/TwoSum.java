import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Create a HashMap to store the array elements and their corresponding indices
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int complement = x - arr[i];
            if (map.containsKey(complement)) {
                int index1 = i + 1;
                int index2 = map.get(complement) + 1;
                System.out.println(index1 + " " + index2);
                return;
            }
            map.put(arr[i], i);
        }

        System.out.println("IMPOSSIBLE");
    }
}
