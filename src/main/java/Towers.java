import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Towers {
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

    int solve() throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(reader.nextInt(), 1);
        while (n-- > 1) {
            int x = reader.nextInt();
            //we get the next int, we need to add this to an existing tower or create new tower
            //if this number is bigger than all previous elements => create new one
            //else we add this to the smallest in the set of bigger element
            var higherEntry = treeMap.higherEntry(x);
            if (higherEntry != null) {
                if (higherEntry.getValue() == 1) {
                    treeMap.remove(higherEntry.getKey()); //if there is multiple key
                } else {//there is multiple entry with the same value
                    treeMap.put(higherEntry.getKey(), higherEntry.getValue() - 1);
                }
            }
            // treeMap.put(x, 1);
            if (treeMap.containsKey(x)) {
                treeMap.put(x, treeMap.get(x) + 1);
            } else {
                treeMap.put(x, 1);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> set :
                treeMap.entrySet()) {
            ans += set.getValue();
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Towers().solve());
    }
}
