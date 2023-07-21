import java.io.PrintWriter;
import java.util.Scanner;

public class GrayCode {


    StringBuilder convertToGrayCode(StringBuilder binaryForm)
    {
        StringBuilder grayCode = new StringBuilder();
        //convert a string of binary form to gray code
        grayCode.append(binaryForm.charAt(0));
        for (int i = 1; i < binaryForm.length(); i++) {
            if (binaryForm.charAt(i) == binaryForm.charAt(i - 1)) {
                grayCode.append("0");
            } else {
                grayCode.append("1");
            }
        }

        return grayCode;
    }
    void solve() {
        Scanner input = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);
        int n = input.nextInt();
        int total = (int) Math.pow(2, n);
        StringBuilder currentState = getFirstState(n);

        printWriter.println(currentState);
        for (int i = 0; i < total-1; i++) {
            currentState = calculateNextState(currentState);
            printWriter.println(convertToGrayCode(currentState));
        }
        printWriter.flush();
        printWriter.close();
    }

    StringBuilder calculateNextState(StringBuilder currentState) {
        //0000 -> 0001
        //From end to begin, whenever I see an 0 -> 1, if I see 1s change to 0
        int lastIndexOfZero = currentState.lastIndexOf("0");
        //change this zero to one
        if (lastIndexOfZero >= 0) {

            for (int i = currentState.length() - 1; i > lastIndexOfZero; i--) {
                if (currentState.charAt(i) == '1') {
                    currentState.replace(i, i + 1, "0");
                }
            }
            currentState.replace(lastIndexOfZero, lastIndexOfZero + 1, "1");
        }
        return currentState;
    }

    StringBuilder getFirstState(int n) {
        StringBuilder firstState = new StringBuilder();
        for (int i = 0; i < n; i++) {
            firstState.append('0');
        }
        return firstState;
    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        grayCode.solve();
    }
}
