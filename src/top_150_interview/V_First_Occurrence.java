package top_150_interview;

public class V_First_Occurrence {
    public static int strStr(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len2 > len1) return -1;
        int res = -1;
        for (int i = 0; i <= len1-len2; i++) {
            boolean check = true;
            for (int j = 0; j < len2; j++) {
                if (s1.charAt(i+j) != s2.charAt(j)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                return i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
    }
}
