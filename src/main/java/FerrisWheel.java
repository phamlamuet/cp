import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class FerrisWheel {
    long solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nx = br.readLine().split(" ");
        long n = Long.parseLong(nx[0]);
        long x = Long.parseLong(nx[1]);
        ArrayList<Long> weightList = new ArrayList<>();
        String[] weights = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            weightList.add(Long.parseLong(weights[i]));
        }
        Collections.sort(weightList);
        int i = 0;
        int j = weightList.size() - 1;
        long ans = 0;
        while (i <= j) {
            long first = weightList.get(i);
            long second = weightList.get(j);
            if (first + second <= x) {
                ans++;
                i++;
                j--;
            } else {
                ans++;
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new FerrisWheel().solve());
    }
}
