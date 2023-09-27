package com.example.problemsolving.string;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = "afrr".toCharArray();
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {

        int start = 0;
        int end = s.length - 1;
        while (start <= end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

//        for (int i=0;i<s.length/2;i++){
//            char temp = s[i];
//            s[i]= s[s.length-i-1];
//            s[s.length-i-1]=temp;
//        }
    }
}
