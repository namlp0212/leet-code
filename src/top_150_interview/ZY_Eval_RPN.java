package top_150_interview;

import java.time.Period;
import java.util.Stack;

public class ZY_Eval_RPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        Integer a, b;
        for (String token : tokens) {
            switch (token) {
                case "*":
                    a = stack.pop();
                    b = stack.pop();

                    stack.add(a * b);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();

                    stack.add(b / a);
                    break;
                case "+":
                    a = stack.pop();
                    b = stack.pop();

                    stack.add(a + b);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();

                    stack.add(b - a);
                    break;
                default:
                    stack.add(Integer.parseInt(token));
                    break;
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
