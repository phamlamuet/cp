import java.util.Scanner;

public class TrailingZeros {
    int solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 0;
        for (int i = 5; i <= n; i += 5) {
            int j = i;
            while (j % 5 == 0) {
                result++;
                j /= 5;
            }
        }

//        for(long i =5;i<=n;i*=5){
//            result+=n/i;
//        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new TrailingZeros().solve());
    }
}
