package top_150_interview;

import java.util.HashSet;
import java.util.Set;

public class ZM_Happy_Number {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            System.out.println("n = " + n);
            n = calculateSquare(n);
            if (n == 1) {
                return true;
            } else {
                if (set.contains(n)) {
                    return false;
                } else {
                    set.add(n);
                }
            }
        }
    }

    public static int calculateSquare(int n) {
        int res = 0;
        int mod;
        while (n > 0) {
            mod = n%10;
            res += mod*mod;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(11111));
    }
}
