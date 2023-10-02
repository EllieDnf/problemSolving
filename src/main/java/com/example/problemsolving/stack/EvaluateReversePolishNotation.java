package com.example.problemsolving.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (String s: tokens) {
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) nums.add(Integer.parseInt(s));
            else {
                int first = nums.pop();
                int sec = nums.pop();
                if (s.equals("+")) nums.push(first+sec);
                if (s.equals("-")) nums.push(sec-first);
                if (s.equals("*")) nums.push(first*sec);
                if (s.equals("/")) nums.push(sec/first);
            }
        }
        return nums.pop();
    }
}
