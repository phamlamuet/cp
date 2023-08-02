/*
   Time Complexity: O(N+M)
   Space Complexity: O(N)

   Where N is the number of elements in the array ARR and M is the number of queries.
*/

import java.util.ArrayList;

public class CollectingNumber2 {

    public static ArrayList<Integer> countRounds(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {

        int n = arr.size();
        int m = queries.size();

        // Create an array answer to store the number of rounds after each operation
        ArrayList<Integer> answer = new ArrayList<Integer>();

        // Maintain an array to store the index of all elements in the array
        int[] positions = new int[n + 2];

        positions[0] = 0;
        positions[n + 1] = n + 1;

        for (int i = 0; i < n; i++) {
            positions[arr.get(i)] = i + 1;
        }

        // Find the total number of rounds of the current permutation
        int totalRounds = 1;

        // Iterate currentNumber from 2 to n
        for (int currentNumber = 2; currentNumber <= n; currentNumber++) {
            // Check if index of currentNumber is less than index of currentNumber-1
            if (positions[currentNumber] < positions[currentNumber - 1]) {
                totalRounds++;
            }
        }

        // Traverse through the array Queries
        for (int j = 0; j < m; j++) {
            // Swap the elements placed at firstIndex and secondIndex
            int firstIndex = queries.get(j).get(0);
            int secondIndex = queries.get(j).get(1);
            int firstValue = arr.get(firstIndex - 1);
            int secondValue = arr.get(secondIndex - 1);

            // Decrement totalRounds by the number of pairs with the index of the first
            // value greater than the second value
            if (positions[firstValue - 1] > positions[firstValue]) {
                totalRounds--;
            }

            if (positions[firstValue] > positions[firstValue + 1]) {
                totalRounds--;
            }

            if (secondValue - 1 != firstValue && positions[secondValue - 1] > positions[secondValue]) {
                totalRounds--;
            }

            if (secondValue + 1 != firstValue && positions[secondValue] > positions[secondValue + 1]) {
                totalRounds--;
            }

            // Swap the elements placed at firstIndex-1 and secondIndex-1 and update the
            // indices in the array positions
            positions[firstValue] = secondIndex;
            positions[secondValue] = firstIndex;

            int temp = arr.get(firstIndex - 1);
            arr.set(firstIndex - 1, arr.get(secondIndex - 1));
            arr.set(secondIndex - 1, temp);

            // Increment totalRounds by the number of pairs with the index of the first
            // value greater than the second value
            if (positions[firstValue - 1] > positions[firstValue]) {
                totalRounds++;
            }

            if (positions[firstValue] > positions[firstValue + 1]) {
                totalRounds++;
            }

            if (secondValue - 1 != firstValue && positions[secondValue - 1] > positions[secondValue]) {
                totalRounds++;
            }

            if (secondValue + 1 != firstValue && positions[secondValue] > positions[secondValue + 1]) {
                totalRounds++;
            }

            // Insert totalRounds in the array answer
            answer.add(totalRounds);
        }

        return answer;

    }

}
