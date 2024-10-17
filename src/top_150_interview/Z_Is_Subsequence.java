package top_150_interview;

public class Z_Is_Subsequence {
    public static boolean isSubsequence(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        int j = 0;
        for (int i = 0; i < c1.length; i++) {
            boolean check = false;
            while (j < c2.length) {
                if (c2[j] == c1[i]) {
                    check = true;
                    j++;
                    break;
                } else {
                    j++;
                }
            }
            if (j == c2.length && !check) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("aaaaaa", "bbaaaa"));
    }
}
