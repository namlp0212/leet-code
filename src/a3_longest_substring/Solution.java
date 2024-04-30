package a3_longest_substring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else {
            char[] c = s.toCharArray();
            int[] result = new int[c.length];
            for (int i = 1; i < c.length; i++) {
                result[i] = -1;
            }
            result[0] = 1;

            for (int i = 1; i < c.length; i++) {
                Set<Character> s1 = new HashSet<>();
                s1.add(c[i]);
                for (int j = i - 1; j >= 0; j--) {
                    if (s1.contains(c[j])) {
                        result[i] = i - j;
                        break;
                    }
                    s1.add(c[j]);
                }
                if (result[i] == -1) {
                    result[i] = i + 1;
                }
            }

            return Arrays.stream(result).max().getAsInt();
        }
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else {
            char[] c = s.toCharArray();
            int result = 1;
            Set<Character> sc = new HashSet<>();
            sc.add(c[0]);
            int l = 0, r = 1;
            while (r < c.length) {
                if (!sc.contains(c[r])) {
                    result = Math.max(result, r - l + 1);
                    sc.add(c[r]);
                    r++;
                } else {
                    while (c[l] != c[r]) {
                        sc.remove(c[l]);
                        l++;
                    }
                    l++;
                    result = Math.max(result, r - l + 1);
                    sc.add(c[r]);
                    r++;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("cdd"));
    }
}
