package top_150_interview;

public class P_Roman_To_Int {
    public static int romanToInt(String s) {
        int len = s.length();
        int res = 0;

        int i = 0;
        char c;
        while (i < len) {
            c = s.charAt(i);

            if (c == 'I') {
                if (i == len-1) {
                    res += 1;
                    i++;
                } else {
                    if (s.charAt(i+1) == 'V') {
                        res += 4;
                        i += 2;
                    } else if (s.charAt(i+1) == 'X') {
                        res += 9;
                        i += 2;
                    } else {
                        res += 1;
                        i++;
                    }
                }
            } else if (c == 'X') {
                if (i == len-1) {
                    res += 10;
                    i++;
                } else {
                    if (s.charAt(i+1) == 'L') {
                        res += 40;
                        i += 2;
                    } else if (s.charAt(i+1) == 'C') {
                        res += 90;
                        i += 2;
                    } else {
                        res += 10;
                        i++;
                    }
                }
            } else if (c == 'C') {
                if (i == len-1) {
                    res += 100;
                    i++;
                } else {
                    if (s.charAt(i+1) == 'D') {
                        res += 400;
                        i += 2;
                    } else if (s.charAt(i+1) == 'M') {
                        res += 900;
                        i += 2;
                    } else {
                        res += 100;
                        i++;
                    }
                }
            } else if (c == 'V') {
                res += 5;
                i++;
            } else if (c == 'L') {
                res += 50;
                i++;
            } else if (c == 'D') {
                res += 500;
                i++;
            } else if (c == 'M') {
                res += 1000;
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
