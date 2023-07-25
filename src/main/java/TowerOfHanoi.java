import java.util.Scanner;

public class TowerOfHanoi {
    StringBuilder movements = new StringBuilder();

    int move(int n, int src, int aux, int dst) {
        int count = 0;
        if (n == 1) {
            movements.append(src).append(" ").append(dst).append("\n");
            return 1;
        }

        count += move(n - 1, src, dst, aux);
        movements.append(src).append(" ").append(dst).append("\n");
        count++;
        count += move(n - 1, aux, src, dst);
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TowerOfHanoi towerOfHanoiV2 = new TowerOfHanoi();
        int numOfMoves = towerOfHanoiV2.move(n, 1, 2, 3);
        System.out.println(numOfMoves);
        System.out.println(towerOfHanoiV2.movements);

    }
}
