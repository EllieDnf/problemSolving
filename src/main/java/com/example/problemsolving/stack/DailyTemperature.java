package com.example.problemsolving.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,40,50,60})));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<temperatures.length;i++){
            while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]) {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }
}
