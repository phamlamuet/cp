import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class TrafficLights {
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

    static class Passage implements Comparable<Passage> {
        int start;
        int end;
        int length;

        public Passage(int start, int end) {
            this.start = start;
            this.end = end;
            this.length = end - start;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Passage passage = (Passage) o;
            return start == passage.start && end == passage.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public int compareTo(Passage o) {
            return this.length - o.length;
        }
    }

    void solve() throws IOException {
        Reader reader = new Reader();
        PrintWriter printWriter = new PrintWriter(System.out);
        StringBuilder output = new StringBuilder("");
        int x = reader.nextInt();
        int n = reader.nextInt();

        TreeSet<Integer> trafficLights = new TreeSet<>();
        trafficLights.add(0);
        trafficLights.add(x);


        TreeSet<Passage> passages = new TreeSet<>();
        Passage max = new Passage(0, x);
        passages.add(max);

        for (int j = 0; j < n; j++){
            int i = reader.nextInt();
            Integer previousTrafficLight = trafficLights.lower(i);
            Integer nextTrafficLight = trafficLights.higher(i);
            trafficLights.add(i);

            Passage first = new Passage(previousTrafficLight, i);
            Passage last = new Passage(i, nextTrafficLight);
            passages.add(first);
            passages.add(last);

            if (previousTrafficLight == max.start && nextTrafficLight == max.end) {
                Passage secondLongest = passages.lower(max);
                if (first.length > last.length) {
                    max = first;
                } else {
                    max = last;
                }

                if (max.length < secondLongest.length) {
                    passages.remove(max);
                    max = secondLongest;
                }
            } else {
                passages.remove(new Passage(previousTrafficLight, nextTrafficLight));
            }

            output.append(max.length).append(" ");
        }
        printWriter.println(output);
        printWriter.flush();
    }

    public static void main(String[] args) throws IOException {
        new TrafficLights().solve();
    }
}
