package top_150_interview;

import javax.swing.*;
import java.util.*;

public class ZE_Matrix_Zeros {
    public static void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (Integer row : rows) {
            for (int i = 0; i < n; i++) {
                matrix[row][i] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            for (Integer col : cols) {
                matrix[i][col] = 0;
            }
        }
    }

    public static void main(String[] args) {

    }
}
