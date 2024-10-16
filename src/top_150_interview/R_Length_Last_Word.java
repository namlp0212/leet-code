package top_150_interview;

public class R_Length_Last_Word {
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        // trim space
        int start = 0, end = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                start++;
            } else {
                break;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                end--;
            } else {
                break;
            }
        }
        int len = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == ' ') {
                len = 0;
            } else {
                len++;
            }
        }
        return len;
    }

    public static int lengthOfLastWordV2(String s) {
        s = s.trim();
        // trim space
        int end = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                end--;
            } else {
                break;
            }
        }
        int len = 0;
        for (int i = end; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                len++;
            } else {
                break;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWordV2("   fly me   to   the moon  "));
    }
}
