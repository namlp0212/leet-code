package top_150_interview;

public class Q_Int_To_Roman {
    public static String intToRoman(int a) {
        StringBuilder res = new StringBuilder();

        int div;
        while (a > 0) {
            if (a >= 1000) {
                div = a / 1000;
                a = a % 1000;
                res.append("M".repeat(div));
            } else if (a >= 900) {
                a = a - 900;
                res.append("CM");
            } else if (a >= 500) {
                a = a - 500;
                res.append("D");
            } else if (a >= 400) {
                a = a - 400;
                res.append("CD");
            } else if (a >= 100) {
                div = a / 100;
                a = a % 100;
                res.append("C".repeat(div));
            } else if (a >= 90) {
                a = a - 90;
                res.append("XC");
            } else if (a >= 50) {
                a = a - 50;
                res.append("L");
            } else if (a >= 40) {
                a = a - 40;
                res.append("XL");
            } else if (a >= 10) {
                div = a / 10;
                a = a % 10;
                res.append("X".repeat(div));
            } else if (a == 9) {
                a = 0;
                res.append("IX");
            } else if (a >= 5) {
                a = a - 5;
                res.append("V");
            } else if (a == 4) {
                a = 0;
                res.append("IV");
            } else {
                res.append("I".repeat(a));
                a = 0;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
