package top_150_interview;

public class T_Reverse_Word {
    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();

        int end = s.length() - 1;
        int curLen = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                end--;
            } else {
                break;
            }
        }

        for (int i = end; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (curLen != 0) {
                    res.append(s, i+1, i+1+curLen);
                    res.append(" ");
                }
                curLen = 0;
            } else {
                curLen++;
            }
        }

        if (curLen > 0) {
            res.append(s, 0, curLen);
            return res.toString();
        } else {
            return res.substring(0, res.length() - 1);
        }
    }

    public static void main(String[] args) {
        reverseWords("  hello world  ");
    }
}
