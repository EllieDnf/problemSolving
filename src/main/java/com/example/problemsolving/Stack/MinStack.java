package com.example.problemsolving.Stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer>minStack;
    public MinStack() {
        stack= new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek()>=val) minStack.push(val);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int popped = stack.pop();
            if (minStack.peek() == popped) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if(!stack.isEmpty()) return stack.peek();
        return -1;
    }

    public int getMin() {
        if (!minStack.isEmpty())return minStack.peek();
        else return -1;
    }
}
