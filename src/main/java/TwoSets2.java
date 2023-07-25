import java.io.PrintWriter;
import java.util.*;

public class TwoSets2 {
    void solve() {
        //two sets problem solution
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        int n = scanner.nextInt();
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(scanner.nextLong());
        }
        Collections.sort(arrayList);

        long sum = 0;
        for (long i :
                arrayList) {
            sum += i;
        }
        long halfSum = sum / 2;


        printWriter.println("YES");

        for (long i:
             arrayList) {
            System.out.print(i+ " ");
        }
        ArrayList<Long> set1 = new ArrayList<>();
        ArrayList<Long> set2 = new ArrayList<>();
        long sum1 = 0;

        for (int i = n - 1; i >= 1; i--) {
            if (sum1 + arrayList.get(i) <= halfSum) {
                sum1 += arrayList.get(i);
                set1.add(arrayList.get(i));
            } else {
                set2.add(arrayList.get(i));
            }
        }


        for (long i : set1) {
            printWriter.print(i + " ");
        }
        printWriter.println("");

        for (long i : set2) {
            printWriter.print(i + " ");
        }

        printWriter.flush();
        printWriter.close();
    }

    public static void main(String[] args) {
        TwoSets2 twoSets = new TwoSets2();
        twoSets.solve();
    }
}
