package top_150_interview;

public class S_Longest_Common_Prefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int len = 0;
        char c;
        loop:
        for (int i = 0; i < 200; i++) {
            if (strs[0].length() > i) {
                c = strs[0].charAt(i);
            } else {
                break;
            }
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() > i) {
                    if (strs[j].charAt(i) != c) {
                        break loop;
                    }
                } else {
                    break loop;
                }
                if (j == strs.length - 1) {
                    len++;
                }
            }
        }
        return strs[0].substring(0, len);
    }

    public static void main(String[] args) {
        String[] str = {"ab", "a"};
        System.out.println(longestCommonPrefix(str));
    }
}
