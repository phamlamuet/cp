import java.util.Map;
import java.util.Scanner;

public class BitStrings {
    long solve(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long result = 1;
        for (int i = 0; i < n; i++) {
            result = (result * 2) % 1000000007;
        }
        return result % 1000000007;
    }
    public static void main(String[] args) {
        System.out.println(new BitStrings().solve());
    }
}
