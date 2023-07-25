import java.io.PrintWriter;
import java.util.*;

public class CreatingStrings {
    public static Set<String> generatePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        Set<String> strSet = new TreeSet<>();
        generatePermutationsHelper(str.toCharArray(), 0, strSet);
        return strSet;
    }

    /**
     * Backtrack(x)
     * if x is not a solution
     * return false
     * if x is a new solution
     * add to list of solutions
     * backtrack(expand x)
     */
    private static void generatePermutationsHelper(char[] arr, int index, Set<String> result) {
        if (index == arr.length - 1) {
            result.add(new String(arr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            generatePermutationsHelper(arr, index + 1, result);
            swap(arr, index, i);
        }
    }

    private static void genPermutations(char[] arr, int currentIndex, Set<String> result) {
        if (currentIndex == arr.length - 1) {
            result.add(new String(arr));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            swap(arr, currentIndex, i);
            genPermutations(arr, currentIndex+1, result);
            
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        PrintWriter printWriter = new PrintWriter(System.out);
        Set<String> permutations = generatePermutations(n);
        printWriter.println(permutations.size());
        for (String perm : permutations) {
            printWriter.println(perm);
        }
        printWriter.flush();
        printWriter.close();

    }
}
