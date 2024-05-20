package a17_letterPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static List<List<String>> ch = new ArrayList<>();
    static {
        {
            List<String> l = new ArrayList<>();
            l.add("a");
            l.add("b");
            l.add("c");
            ch.add(l);
        }
        {
            List<String> l = new ArrayList<>();
            l.add("d");
            l.add("e");
            l.add("f");
            ch.add(l);
        }
        {
            List<String> l = new ArrayList<>();
            l.add("g");
            l.add("h");
            l.add("i");
            ch.add(l);
        }
        {
            List<String> l = new ArrayList<>();
            l.add("j");
            l.add("k");
            l.add("l");
            ch.add(l);
        }
        {
            List<String> l = new ArrayList<>();
            l.add("m");
            l.add("n");
            l.add("o");
            ch.add(l);
        }
        {
            List<String> l = new ArrayList<>();
            l.add("p");
            l.add("q");
            l.add("r");
            l.add("s");
            ch.add(l);
        }
        {
            List<String> l = new ArrayList<>();
            l.add("t");
            l.add("u");
            l.add("v");
            ch.add(l);
        }
        {
            List<String> l = new ArrayList<>();
            l.add("w");
            l.add("x");
            l.add("y");
            l.add("z");
            ch.add(l);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return result;
        }
        List<String> resultArr = new ArrayList<>();
        letterCombinations(result, resultArr, digits, 0, digits.length());

        return result;
    }

    public static void letterCombinations(List<String> finalResult, List<String> res, String digits, int index, int len) {
        if (index == len) {
            StringBuilder sb = new StringBuilder();
            for (String r : res) {
                sb.append(r);
            }
            finalResult.add(sb.toString());
            return;
        }
        Integer numPhone = Integer.parseInt(String.valueOf(digits.charAt(index))) - 2;
        List<String> chArr = ch.get(numPhone);

        for (String s : chArr) {
            res.add(s);
            letterCombinations(finalResult, res, digits, index + 1, len);
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> result = letterCombinations("");
        for (String r : result) {
            System.out.println(r);
        }
    }
}
