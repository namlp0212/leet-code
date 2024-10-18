package top_150_interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ZH_Is_Isomorphic {
    public static boolean isIsomorphic(String s, String t) {
        int len = s.length();
        if (t.length() != len) {
            return false;
        }

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        char c1, c2;
        for (int i = 0; i < len; i++) {
            c1 = s.charAt(i);
            c2 = t.charAt(i);
            if (!map1.containsKey(c1)) {
                map1.put(c1, c2);
            } else {
                if (map1.get(c1) != c2) {
                    return false;
                }
            }
            if (!map2.containsKey(c2)) {
                map2.put(c2, c1);
            } else {
                if (map2.get(c2) != c1) {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "title"));
    }
}
