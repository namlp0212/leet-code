package top_150_interview;
import java.util.*;

public class Y_Valid_Palindrome {
    public static boolean isPalindrome(String s) {
        List<Character> listC = new ArrayList<>();

        Character c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
                c = Character.toLowerCase(s.charAt(i));
                listC.add(c);
            } else if ('0' <= c && c <= '9') {
                listC.add(c);
            }
        }
        return isPalindrome(listC);
    }

    public static boolean isPalindrome(List<Character> c) {
        int len = c.size();
        int halfLen = c.size() / 2;

        for (int i = 0; i < halfLen; i++) {
            if (!Objects.equals(c.get(i), c.get(len - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeV2(String s) {
        int left = 0, right = s.length() - 1;

        Character cl, cr;
        while (left < right) {
            cl = s.charAt(left);
            cr = s.charAt(right);

            if (!isNumericOrAlpha(cl)) {
                left++;
                continue;
            }
            if (!isNumericOrAlpha(cr)) {
                right--;
                continue;
            }

            cl = Character.toLowerCase(cl);
            cr = Character.toLowerCase(cr);

            if (cl != cr) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }

    public static boolean isNumericOrAlpha(Character c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9');
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
}
