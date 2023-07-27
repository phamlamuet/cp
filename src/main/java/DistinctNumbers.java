import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class DistinctNumbers {
    int solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Long> set = new HashSet<>();
        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            set.add(Long.parseLong(numbers[i]));
        }
        return set.size();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new DistinctNumbers().solve());
    }
}
