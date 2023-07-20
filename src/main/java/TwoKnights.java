import java.util.Scanner;

public class TwoKnights {
    /**
     * consider 2*3 and 3*2 boxes, there are 2 ways to place 2 knights that attack each other
     * so we have to calculate how many boxes of these types are there on a board of size k*k
     * and we got: attack = 2*2 * (k-1) * (k-2)
     */
    void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) { // i is the size of the board
                long k = i;
                long total = k * k * (k * k - 1) / 2; // total number of ways to place 2 knights on a board of size k
                long attack = 2 * 2 * (k - 1) * (k - 2); // number of ways to place 2 knights on a board of size k that attack each other
               //if K<3 it just canceled out the attack
                System.out.println(total - attack);
        }
    }

    public static void main(String[] args) {
        TwoKnights twoKnights = new TwoKnights();
        twoKnights.solve();
    }
}
