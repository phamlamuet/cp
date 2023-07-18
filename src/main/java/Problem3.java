import java.util.Scanner;

public class Problem3 {
    String adn;

    int solve() {
        Scanner scanner = new Scanner(System.in);
        adn = scanner.nextLine();

        if (adn.length() < 2) {
            return adn.length();
        }

        int max = 1;
        int current_max = max;


        for (int i = 1; i <= adn.length() - 1; i++) {
            if (adn.charAt(i) == adn.charAt(i-1)) {   //check if the current char equals the previous char
                current_max++;
                if (max < current_max) {
                    max = current_max;
                }
            } else {  //commit
                current_max = 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.solve());
    }
}
