import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ConcertTicket {
    /**
     * this got 2 tests TLE
     */
    void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        String[] nm = br.readLine().split(" ");
        long n = Long.parseLong(nm[0]);
        long m = Long.parseLong(nm[1]);

        ArrayList<Integer> lstTicket = new ArrayList<>();
        ArrayList<Integer> lstAfford = new ArrayList<>();

        String[] tickets = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            lstTicket.add(Integer.parseInt(tickets[i]));
        }

        String[] affords = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            lstAfford.add(Integer.parseInt(affords[i]));
        }

        TreeMap<Integer, Integer> concertMap = new TreeMap<>();
        for (Integer ticket : lstTicket) {
            if (concertMap.containsKey(ticket)) {
                concertMap.put(ticket, concertMap.get(ticket) + 1);
            } else {
                concertMap.put(ticket, 1);
            }
        }
        Map.Entry<Integer, Integer> match;

        for (int i = 0; i < m; i++) {
            int temp = lstAfford.get(i);
            match = concertMap.lowerEntry(temp + 1);
            if (match != null) {
                printWriter.println(match.getKey());
                if (match.getValue() == 1)
                    concertMap.remove(match.getKey());
                else
                    concertMap.put(match.getKey(), match.getValue() - 1);
            } else
                printWriter.println("-1");
        }

        printWriter.flush();
        printWriter.close();
    }

    public static void main(String[] args) throws IOException {
        new ConcertTicket().solve();
    }
}