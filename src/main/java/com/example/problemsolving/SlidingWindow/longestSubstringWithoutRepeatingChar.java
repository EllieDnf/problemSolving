package com.example.problemsolving.SlidingWindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class longestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int[] charIndex = new int[128];
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            i = Math.max(charIndex[c], i);
            max = Math.max(max, j - i + 1);
            charIndex[c] = j + 1;
        }
        return max;
    }
    public static int lengthOfLongestSubstring2(String s) {
        Queue<Character> chars = new LinkedList<>();
        int idx=0;
        int max=0;
        while (idx<s.length()){
            char ch= s.charAt(idx);
            if (!chars.contains(ch)) {
                chars.add(ch);
                max= Math.max(max, chars.size());
                idx++;
            }
            else {
                while (chars.remove() !=ch){

                }
            }
            System.out.println(chars);
        }
        return max;
    }
}
