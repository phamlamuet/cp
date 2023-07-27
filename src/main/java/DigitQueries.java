import java.io.PrintWriter;
import java.util.Scanner;

public class DigitQueries {
    class Triple {
        Long level;
        Long current;
        Long remain;
        Triple(long level, long current, long remain) {
            this.level = level;
            this.current = current;
            this.remain = remain;
        }
        @Override
        public String toString() {
            return "(level,current,remain)  = " + level + ", " + current + ", " + remain;
        }
    }

    void solve() {
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        PrintWriter printWriter = new PrintWriter(System.out);
        while (q-- > 0) {
            long k = input.nextLong();
            var p = getLevelAndRemain(k);
            if (p.remain == 0) {
                printWriter.println((int) ((p.current - 1) % 10));
            } else {
                long nextNum = p.current + 1;
                String ans = String.valueOf(nextNum);
                printWriter.println(ans.charAt(Math.toIntExact(p.remain - 1)));
            }
        }
        printWriter.flush();
        printWriter.close();
    }

    /**
     * 1-9 -> level 1
     * 10 - 99 -> level 2
     * 100 - 999 -> level 3
     */
    Triple getLevelAndRemain(long k) {
        long level = 1;
        long remain = 0;
        while (true) {
            long sub = (long) (9 * (level) * Math.pow(10, level - 1));
            if (k - sub > 0) {
                k -= sub;
                level++;
            } else {
                break;
            }
        }
        remain = k;
        long startNumberOfThisLevel = (long) Math.pow(10, level - 1); //803->100
        long currrent = 0;
        if (remain % level == 0) {
            currrent = remain / level + startNumberOfThisLevel;
            return new Triple(level, currrent, 0);
        } else {
            currrent = remain / level + startNumberOfThisLevel - 1;
            remain = remain % level;
            //wish to also return the remain
            return new Triple(level, currrent, remain);
        }
    }

    public static void main(String[] args) {
        new DigitQueries().solve();
    }
}
