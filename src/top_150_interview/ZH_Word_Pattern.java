package top_150_interview;

import java.util.HashMap;
import java.util.Map;

public class ZH_Word_Pattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] arrS = s.split(" ");

        if (arrS.length != pattern.length()) return false;
        String[] p = new String[26];
        Map<String, Character> map = new HashMap<>();

        char c;
        for (int i = 0; i < arrS.length; i++) {
            c = pattern.charAt(i);
            if (p[c - 'a'] == null) {
                p[c - 'a'] = arrS[i];
            } else {
                if (!p[c - 'a'].equals(arrS[i])) {
                    return false;
                }
            }

            if (!map.containsKey(arrS[i])) {
                map.put(arrS[i], c);
            } else {
                if (map.get(arrS[i]) != c) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
}
