package top_150_interview;

public class ZJ_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        int[] num = new int[26];

        for (char c : s.toCharArray()) {
            num[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (num[c - 'a'] <= 0) {
                return false;
            } else {
                num[c - 'a']--;
            }
        }
        for (int i : num) {
            if (i > 0) return false;
        }
        return true;
    }
}
