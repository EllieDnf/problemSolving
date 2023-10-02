package com.example.problemsolving.Stack;

import java.util.Stack;

public class ValidParantheses {
    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
    public static boolean isValid(String s) {
        Stack<Character> charS= new Stack<>();
        int idx=0;
        while(idx<s.length()){
            if (charS.isEmpty()) charS.push(s.charAt(idx));
            else if (s.charAt(idx) ==')' && charS.peek()=='(' ) charS.pop();
            else if (s.charAt(idx) ==']' && charS.peek()=='[' ) charS.pop();
            else if (s.charAt(idx) =='}' && charS.peek()=='{' ) charS.pop();
            else charS.push(s.charAt(idx));
            idx++;
        }
        return charS.empty();
    }
}
