import java.util.HashSet;
import java.util.Scanner;
public class SudokuValidator {
    public static void main(String[] args) {
        char[][] sudokuBoard = new char[9][9];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            String row = scanner.nextLine();
            sudokuBoard[i] = row.toCharArray();
        }
        if (isValidSudoku(sudokuBoard)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }
    private static boolean isValidSudoku(char[][] board) {
        HashSet<Character> row = new HashSet<>();
        HashSet<Character> column = new HashSet<>();
        HashSet<Character> smallSqr = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            row.clear();
            column.clear();
            for (int j = 0; j < 9; j++) {
                char r = board[i][j];
                char c = board[j][i];
                if ((r != '.' && !row.add(r)) || (c != '.' && !column.add(c))) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                smallSqr.clear();
                int rows = i + 3;
                int cols = j + 3;
                for (int k = i; k < rows; k++) {
                    for (int l = j; l < cols; l++) {
                        char c = board[k][l];
                        if (c != '.' && !smallSqr.add(c)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
