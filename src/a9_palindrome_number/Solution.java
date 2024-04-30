package a9_palindrome_number;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        List<Integer> digits = new ArrayList<>();
        while (x > 0) {
            digits.add(x % 10);
            x /= 10;
        }
        int totalDigit = digits.size();
        int halfTotalDigit = totalDigit / 2;
        for (int i = 0; i < halfTotalDigit; i++) {
            if (digits.get(i) != digits.get(totalDigit - i - 1)) return false;
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) return false;

        int y = x;
        long reverse = 0;
        int mod = 0;
        while (x != 0) {
           mod = x % 10;
           reverse = 10 * reverse + mod;
           x = x / 10;
        }
        if (reverse > Integer.MAX_VALUE) return false;
        if (y != (int)reverse) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(12321));
    }
}
