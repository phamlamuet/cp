import java.util.Scanner;

public class ChessboardAndQueens {
    static int count = 0;

    public static void main(String[] args) {
        char[][] chessboard = new char[8][8];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 8; i++) {
            String line = scanner.next();
            chessboard[i] = line.toCharArray();
        }

        backtrackQueens(chessboard, 0);
        System.out.println(count);
    }

    private static void backtrackQueens(char[][] chessboard, int row) {
        if (row == 8) {
            count++;
            return;
        }

        for (int col = 0; col < 8; col++) {
            if (isSafe(chessboard, row, col)) {
                chessboard[row][col] = 'Q';
                backtrackQueens(chessboard, row + 1);
                chessboard[row][col] = '.';  //backtrack the state of the table.
            }
        }
    }

    private static boolean isSafe(char[][] chessboard, int row, int col) {
        int i, j;

        //check obstacles *
        if (chessboard[row][col] == '*') {
            return false;
        }
        // Check this column on top side
        for (i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper diagonal on the right side
        for (i = row, j = col; i >= 0 && j < 8; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
