package a7_reverse_integer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static int reverse(int x) {
        boolean isPositive = true;
        if (x < 0) {
            x = Math.abs(x);
            isPositive = false;
        }
        int numDigit = 0;
        List<Integer> digits = new ArrayList<>();
        while (x > 0) {
            numDigit++;
            digits.add(x % 10);
            x = x / 10;
        }
        int result = 0;
        for (int i = 1; i <= numDigit; i++) {
            if (Integer.MAX_VALUE - digits.get(numDigit - i) * Math.pow(10, i - 1) < result) {
                return 0;
            } else {
                result += digits.get(numDigit - i) * Math.pow(10, i - 1);
            }
        }
        if (!isPositive) return 0 - result;
        return result;
    }

    public static int reverse2(int x) {
        long result = 0;
        int mod = 0;
        while (x != 0) {
            mod = x % 10;
            result = result * 10 + mod;
            x = x/10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }
    public static void main(String[] args) {
        System.out.println(reverse2(-1234567891));
    }
}
