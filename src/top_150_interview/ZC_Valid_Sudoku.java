package top_150_interview;

import java.util.HashSet;
import java.util.Set;

public class ZC_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        // row
        for (int i = 0; i < 9; i++) {
            Set<Character> c = new HashSet<>();
            Set<Character> c2 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (c.contains(board[i][j])) {
                        return false;
                    } else {
                        c.add(board[i][j]);
                    }
                }

                if (board[j][i] != '.') {
                    if (c2.contains(board[j][i])) {
                        return false;
                    } else {
                        c2.add(board[j][i]);
                    }
                }
            }
        }

        // matrix 3*3
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Set<Character> c = new HashSet<>();

                for (int x = 3*i; x < 3*i+3; x++) {
                    for (int y = 3*j; y < 3*j+3; y++) {
                        if (board[x][y] != '.') {
                            if (c.contains(board[x][y])) {
                                return false;
                            } else {
                                c.add(board[x][y]);
                            }
                        }
                    }
                }

            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
