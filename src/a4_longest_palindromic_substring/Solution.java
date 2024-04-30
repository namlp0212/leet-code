package a4_longest_palindromic_substring;

public class Solution {

    // native
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        } else {
            char[] c = s.toCharArray();
            int l = 0, r = 0, maxLen = 0;
            for (int i = 0; i < c.length; i++) {
                for (int j = i; j >= 0; j--) {
                    if (isPalindrome(c, j, i)) {
                        if (maxLen < (i - j + 1)) {
                            maxLen = i - j + 1;
                            l = j;
                            r = i;
                        }
                    }
                }
            }

            return s.substring(l, r + 1);
        }
    }

    private static boolean isPalindrome(char[] c, int l, int r) {
        int sum = l + r;
        for (int i = l; i <= sum/2; i++) {
            if (c[i] != c[sum - i]) return false;
        }

        return true;
    }

    // dynamic programing
    public static String longestPalindrome2(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        } else {
            char[] c = s.toCharArray();
            int rs[][] = new int[c.length][c.length];

            int maxLen = 1, startIdx = 0;

            for (int i = 0; i < c.length; i++) {
                rs[i][i] = 1;
            }

            for (int i = 0; i < c.length - 1; i++) {
                if (c[i] == c[i+1]) {
                    rs[i][i+1] = 1;
                    startIdx = i;
                    maxLen = 2;
                }
            }

            for (int k = 3; k <= c.length; k++) {
                for (int i = 0; i < c.length - k + 1; i++) {
                    int j = i + k - 1;
                    if (rs[i+1][j-1] == 1 && c[i] == c[j]) {
                        rs[i][j] = 1;
                        if (k > maxLen) {
                            startIdx = i;
                            maxLen = k;
                        }
                    }
                }
            }

            return s.substring(startIdx, startIdx + maxLen);
        }
    }

    // sliding window
    public static String longestPalindrome3(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        } else {
            char[] c = s.toCharArray();

            int startIdx = 0, endIdx = 0;

            for (int i = 0; i < c.length; i++) {
                int left = i - 1;
                int right = i + 1;
                while (left >= 0 && right < c.length && c[left] == c[right]) {
                    if (endIdx - startIdx < right - left) {
                        startIdx = left;
                        endIdx = right;
                    }
                    left--;
                    right++;
                }

                left = i;
                right = i + 1;
                while (left >= 0 && right < c.length && c[left] == c[right]) {
                    if (endIdx - startIdx < right - left) {
                        startIdx = left;
                        endIdx = right;
                    }
                    left--;
                    right++;
                }
            }


            return s.substring(startIdx, endIdx + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome3("cbbd"));
    }
}
