package top_150_interview;
import java.util.*;

public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        return spiralOrder(matrix, 0, 0, matrix.length-1, matrix[0].length-1);
    }

    public static List<Integer> spiralOrder(int[][] matrix, int r1, int c1, int r2, int c2) {
        List<Integer> res = new ArrayList<>();
        for (int i = c1; i <= c2; i++) {
            res.add(matrix[r1][i]);
        }
        for (int i = r1+1; i <= r2; i++) {
            res.add(matrix[i][c2]);
        }
        if (r1 != r2) {
            for (int i = c2 - 1; i >= c1; i--) {
                res.add(matrix[r2][i]);
            }
        }

        if (c1 != c2) {
            for (int i = r2 - 1; i >= r1 + 1; i--) {
                res.add(matrix[i][c1]);
            }
        }

        r1++;
        c1++;
        r2--;
        c2--;
        if (r1 < r2 || c1 < c2) {
            return res;
        } else {
            res.addAll(spiralOrder(matrix, r1, c1, r2, c2));
            return res;
        }
    }


}
