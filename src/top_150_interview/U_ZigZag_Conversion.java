package top_150_interview;

import java.util.*;
public class U_ZigZag_Conversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        if (s == null || s.isBlank()) {
            return "";
        } else {
            List<List<Character>> table = new ArrayList<>();

            for (int i = 0; i < numRows; i++) {
                table.add(new ArrayList<>());
            }
            table.get(0).add(s.charAt(0));

            int numInCycle = 2 * (numRows - 1);

            int totalCycle = (s.length() - 1) / numInCycle;
            for (int cycle = 0; cycle < totalCycle; cycle++) {
                table.get(0).add(s.charAt((cycle+1)*numInCycle));
                for (int i = 1; i < numRows - 1; i++) {
                    table.get(i).add(s.charAt(cycle*numInCycle + i));
                    table.get(i).add(s.charAt((cycle+1)*numInCycle - i));
                }
                table.get(numRows-1).add(s.charAt(cycle*numInCycle + numRows - 1));
            }

            int mod = (s.length() - 1) % numInCycle;
            for (int i = 1; i <= mod; i++) {
                if (i <= (numRows - 1)) {
                    table.get(i).add(s.charAt(totalCycle*numInCycle + i));
                } else {
                    table.get(numRows - 1 - (i - (numRows-1))).add(s.charAt(totalCycle*numInCycle + i));
                }
            }

            StringBuilder res = new StringBuilder();
            for (List<Character> listC : table) {
                for (Character c : listC) {
                    res.append(c);
                }
            }

            return res.toString();
        }
    }

    public static String convertV2(String s, int numRows) {
        if (numRows == 1 || s.length() < numRows) return s;
        StringBuilder[] arr = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder();
        }

        boolean isGoingDown = true;
        int curRow = 0;
        int numInCycle = 2 * (numRows - 1);
        int mod;
        for (int i = 0; i < s.length(); i++) {
            arr[curRow].append(s.charAt(i));
            mod = i % numInCycle;
            isGoingDown = mod < numRows - 1;
            if (isGoingDown) {
                curRow++;
            } else {
                curRow--;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(arr[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convertV2("PAYPALISHIRING", 4));
    }
}
