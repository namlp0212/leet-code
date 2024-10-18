package top_150_interview;

import java.util.*;
public class ZK_Group_Anagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        String s;
        List<String> list;
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            s = new String(c);
            if (map.containsKey(s)) {
                list = map.get(s);
                list.add(str);
            } else {
                list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsV2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        int[] alpha = new int[26];
        for (String str : strs) {
            Arrays.fill(alpha, 0);
            for (char c : str.toCharArray()) {
                alpha[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (alpha[i] > 0) {
                    sb.append(i+'a').append(alpha[i]);
                }
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
