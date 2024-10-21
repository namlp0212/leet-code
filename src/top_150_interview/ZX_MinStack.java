package top_150_interview;

import java.util.*;
public class ZX_MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** Initialize your data structure here. */
    public ZX_MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        stack.push(x);

        // Nếu minStack rỗng hoặc x nhỏ hơn hoặc bằng phần tử trên cùng của minStack
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    /** Removes the element on top of the stack. */
    public void pop() {
        int top = stack.pop();

        // Nếu phần tử bị pop ra bằng với phần tử trên cùng của minStack, pop minStack
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    /** Get the top element. */
    public int top() {
        return stack.peek();
    }

    /** Retrieve the minimum element in the stack. */
    public int getMin() {
        return minStack.peek();
    }
}
