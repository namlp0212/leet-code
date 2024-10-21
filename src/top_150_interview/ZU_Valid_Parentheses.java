package top_150_interview;

import java.util.Objects;
import java.util.Properties;
import java.util.Stack;

public class ZU_Valid_Parentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Character c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (c == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (c == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[{(}]"));
    }
}
