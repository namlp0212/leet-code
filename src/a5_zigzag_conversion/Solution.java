package a5_zigzag_conversion;

import java.util.Arrays;

public class Solution {

    public static String convert(String s, int numRows) {
        if (s == null || s.isBlank()) {
            return "";
        } else {
            char[] c = s.toCharArray();

            char defaultChar = '\u0000';
            char[][] rs = new char[numRows][c.length/2 + 1];
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j <= c.length / 2; j++) {
                    rs[i][j] = defaultChar;
                }
            }
            int beforeNumRow = numRows - 1;
            if (beforeNumRow == 0) {
                return s;
            }

            for (int i = 0; i <= c.length / 2; i++) {
                for (int j = 0; j < numRows; j++) {
                    if (i == 0 || i % beforeNumRow == 0) {
                        if (i * 2 + j < c.length) {
                            rs[j][i] = c[i * 2 + j];
                        }
                    } else if ( (i + j) % beforeNumRow == 0) {
                        if (i * 2 + j < c.length) {
                            rs[j][i] = c[i * 2 + j];
                        }
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j <= c.length / 2; j++) {
                    if (rs[i][j] != defaultChar) result.append(rs[i][j]);
                }
            }
            return result.toString();
        }
    }

//    public static String convert2(String s, int numRows) {
//        if (s == null || s.isBlank()) {
//            return "";
//        } else {
//            char[] c = s.toCharArray();
//
//            char[] rs = new char[c.length];
//
//            int beforeNum = numRows - 1;
//            if (beforeNum == 0) return s;
//            else {
//                for (int i = 0; i < c.length; i++) {
//
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }
}
