import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Apartment {
    long solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmk = br.readLine().split(" ");
        long n = Long.parseLong(nmk[0]);
        long m = Long.parseLong(nmk[1]);
        long k = Long.parseLong(nmk[2]);

        ArrayList<Long> lstDesiredSize = new ArrayList<>();
        String[] desiredSizes = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            lstDesiredSize.add(Long.parseLong(desiredSizes[i]));
        }

        ArrayList<Long> lstAvailableSize = new ArrayList<>();
        String[] availableSizes = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            lstAvailableSize.add(Long.parseLong(availableSizes[i]));
        }

        Collections.sort(lstDesiredSize);
        Collections.sort(lstAvailableSize);

        long ans = 0L;
        int i = lstDesiredSize.size() -1;
        int j = lstAvailableSize.size() -1;
        for (; i >= 0 && j >= 0; ) {
            long desired = lstDesiredSize.get(i);
            long avail = lstAvailableSize.get(j);

            if(desired>avail+k){
                i--;
                continue;
            }
            if (inDesiredRange(desired, avail, k)) {
                ans++;
                i--;
                j--;
            } else {
                j--;
            }
        }
        return ans;
    }

    boolean inDesiredRange(long a, long b, long k) {
        return (a >= b - k && a <= b + k);
    }

    public static void main(String[] args) throws IOException {
        Apartment apartment = new Apartment();
        System.out.println(apartment.solve());
    }
}

