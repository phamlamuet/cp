import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * It's not necessary a HashMap, a Set for containing the sequence is good as well
 */
public class Playlist {
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
        ArrayList<Integer> arrayList = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> inMap = new HashMap<>();
        int max = 1;
        int count = 1;
        int f = reader.nextInt();
        map.put(f, 0);
        arrayList.add(f);
        int lastIndex = 0;
        for (int i = 1; i < n; i++) {
            int k = reader.nextInt();
            arrayList.add(k);
            Integer x = map.get(k);
            //if map contain the key -> delete all key from (lastIndex,i) 3 3 3 [3 5] 1 (5)
            //then update the lastIndex, update the map as well
            //else -> count++, update the map
            if (x != null) {
                for (int j = lastIndex; j <= x; j++) {
                    map.remove(arrayList.get(j));
                    count--;
                }
                lastIndex = x + 1;
            }

            map.put(k, i);
            count++;
            if (max < count) {
                max = count;
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Playlist().solve());
    }
}
