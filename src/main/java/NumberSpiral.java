import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Math.*;

class Point {
    long x;
    long y;

    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(x,y) = (" + x + "," + y + ")";
    }
}

public class NumberSpiral {

    long solve(Point point) {
        long round = max(point.x, point.y);
        Point startPointOfThisRound = calculateTheStartPointOfTheRound(round);
        long distance = calculateStepsBetweenTwoPoint(point, startPointOfThisRound);
        long distanceFromStart = stepsToGetToTheFirstPointOfARoundFromZero(round);
        return distanceFromStart + distance;
    }

    Point calculateTheStartPointOfTheRound(long round) {
        if (round % 2 == 0) {
            return new Point(round, 1);
        } else {
            return new Point(1, round);
        }
    }

    /**
     * assume that the start point to cal is (0,0)
     *
     * @param round
     * @return sum of steps
     * <p>
     * 1 +
     */
    long stepsToGetToTheFirstPointOfARoundFromZero(long round) {
        /**
         * 0 -> 1(our input)    --> 1 (our output)
         * 1 -> 2    -->1
         * 2 -> 3    -->3
         * 3 -> 4    -->5
         * 4 -> 5    -->7
         * 5 --> 6   -->9
         */
        if (round == 1) {
            return 1;
        }
        long n = round - 1;
        return 1 + n * 1 + n * (n - 1) / 2 * 2;
    }

    long calculateStepsBetweenTwoPoint(Point p1, Point p2) {
        return max(p1.x, p2.x) - min(p1.x, p2.x) + max(p1.y, p2.y) - min(p1.y, p2.y);
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        long n = Long.parseLong(bufferedReader.readLine());
        NumberSpiral numberSpiral = new NumberSpiral();
        PrintWriter out = new PrintWriter(System.out);
        while (n > 0) {
            String[] input = bufferedReader.readLine().split(" ");
            long y = Long.parseLong(input[0]);
            long x = Long.parseLong(input[1]);
            Point point = new Point(x, y);
            out.println(numberSpiral.solve(point));
            n--;
        }
        out.flush();
        out.close();
    }
}
