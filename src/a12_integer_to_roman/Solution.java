package a12_integer_to_roman;

public class Solution {
    // I: 1, V: 5, X: 10, L: 50, C: 100, D: 500, M: 1000
    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int a, b;
        a = num / 1000;
        b = num % 1000;
        result.append("M".repeat(a));

        if (b >= 900) {
            b = b - 900;
            result.append("CM");
        } else {
            a = b / 500;
            b = b % 500;
            result.append("D".repeat(a));
        }

        if (b >= 400) {
            b = b - 400;
            result.append("CD");
        } else {
            a = b / 100;
            b = b % 100;
            result.append("C".repeat(a));
        }

        if (b >= 90) {
            b = b - 90;
            result.append("XC");
        } else {
            a = b / 50;
            b = b % 50;
            result.append("L".repeat(a));
        }

        if (b >= 40) {
            b = b - 40;
            result.append("XL");
        } else {
            a = b / 10;
            b = b % 10;
            result.append("X".repeat(a));
        }

        if (b >= 9) {
            b -= 9;
            result.append("IX");
        } else {
            a = b / 5;
            b = b % 5;
            result.append("V".repeat(a));
        }

        if (b == 4) {
            result.append("IV");
        } else {
            result.append("I".repeat(b));
        }

        return result.toString();
    }

    private static StringBuilder printStr(int times, String sample) {
        if (times > 0) {
            StringBuilder res = new StringBuilder();
            res.append(String.valueOf(sample).repeat(times));
            return res;
        } else {
            return new StringBuilder();
        }
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));;
    }
}
