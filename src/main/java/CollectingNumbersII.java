import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Just the enhance version of Collecting Number 1 and analysis the change impact of swapping 2 number
 * Current : The input has problem that need to enter to read the last number
 * The logic for change impact is broken
 * Cost a lot of time to fix
 */
public class CollectingNumbersII {

    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<Integer, Integer> inMap = new HashMap<>();

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    int getRound(HashMap<Integer, Integer> map, int n) {
        int round = 1;
        int currentNum = 1;
        while (currentNum < n) {
            int posNum = map.get(currentNum);
            int nextNum = currentNum + 1;
            int posNextNum = map.get(nextNum);
            if (posNextNum < posNum) {
                round++;
            }
            currentNum = nextNum;
        }
        return round;
    }

    void solve() throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int nOps = reader.nextInt();

        for (int i = 1; i <= n; i++) {
            int k = reader.nextInt();
            map.put(k, i);
            inMap.put(i, k);
        }


        int round = getRound(map, n);
        for (int i = 0; i < nOps; i++) {

            int posInput1 = reader.nextInt();
            int posInput2 = reader.nextInt();
//            int impact = getRoundImpact(posInput1, posInput2);
//            round += impact;
//            System.out.println(round);
            System.out.println(posInput1 + " - " + posInput2);
        }
    }

    /**
     * if the next number from the right to left -> round+=1
     * if the next number from the left to the right -> round-1
     * if the previous number from right to the left -> round=-1
     * if the previous number from left to right ->round+1
     *
     * @param posInput1
     * @param posInput2
     * @return
     */
    int getRoundImpact(int posInput1, int posInput2) {
        int impact = 0;
        int firstNum = inMap.get(posInput1);
        int secondNum = inMap.get(posInput2);
        Integer prevFirstNumPos = map.get(firstNum - 1);
        Integer nextFirstNumPos = map.get(firstNum + 1);
        Integer prevSecondNumPos = map.get(secondNum - 1);
        Integer nextSecondNumPos = map.get(secondNum + 1);
        //we have 3 couple of numbers before swap here, now update and calculate 3 new couple of number
        map.put(firstNum, posInput2);
        map.put(secondNum, posInput1);
        inMap.put(posInput1, secondNum);
        inMap.put(posInput2, firstNum);
        //recalculate all the variables (new pos1, new pos2)
        int newPosFirstNum = posInput2;
        int newPostSecondNum = posInput1;
//        int newFirstNum = secondNum;
//        int newSecondNum = firstNum;
        Integer newPrevFirstNumPos = map.get(firstNum - 1);
        Integer newNextFirstNumPos = map.get(firstNum + 1);
        Integer newPrevSecondNumPos = map.get(secondNum - 1);
        Integer newNextSecondNumPos = map.get(secondNum + 1);
        // the change logic
        if (nextFirstNumPos != null && newNextFirstNumPos != null) {
            if (posInput1 > nextFirstNumPos && newPosFirstNum < newNextFirstNumPos) {
                impact += 1;
            }
        }
        if (prevFirstNumPos != null && newPrevFirstNumPos != null) {
            if (posInput1 < prevFirstNumPos && newPrevFirstNumPos < newPosFirstNum) {
                impact -= 1;
            }
        }
        if (nextSecondNumPos != null && newNextSecondNumPos != null) {
            if (posInput2 > nextSecondNumPos && newPostSecondNum < newNextSecondNumPos) {
                impact -= 1;
            }
        }
        if (prevSecondNumPos != null && newPrevSecondNumPos != null) {
            if (posInput2 < prevSecondNumPos && newPrevSecondNumPos < newPostSecondNum) {
                impact += 1;
            }
        }
        if (nextFirstNumPos != null && prevFirstNumPos != null)
            if (posInput2 == nextFirstNumPos || posInput2 == prevFirstNumPos) {
                if (firstNum > secondNum) {
                    impact += 1;
                } else {
                    impact -= 1;
                }
            }
        return impact;
    }

    public static void main(String[] args) throws IOException {
        new CollectingNumbersII().solve();
    }
}
