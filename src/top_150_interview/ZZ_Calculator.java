//package top_150_interview;
//
//import java.util.Stack;
//
//public class ZZ_Calculator {
//    public static int calculate(String s) {
//        Stack<String> stack = new Stack<>();
//        Character c;
//        for (int i = 0; i < s.length(); i++) {
//            c = s.charAt(i);
//            switch (c) {
//                case '+':
//                    if (i+1 < s.length()) {
//                        if (s.charAt(i+1) != '(') {
//                            int val = Integer.parseInt(stack.pop().toString()) + Integer.parseInt(String.valueOf(s.charAt(i+1)));
//                            stack.add(String.valueOf(val));
//                        } else {
//                            stack.add("(");
//                        }
//                    }
//                    break;
//                case '-':
//                    if (i+1 < s.length()) {
//                        if (s.charAt(i+1) != '(') {
//
//                        } else {
//                            stack.add("(");
//                        }
//                    }
//                    break;
//            }
//        }
//    }
//}
