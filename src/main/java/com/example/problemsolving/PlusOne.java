package com.example.problemsolving;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9,9})));
    }

    public static int[] plusOne(int[] digits) {
        boolean allDigits9 =true;
        for (int x:digits) {
            if (x!=9) allDigits9=false;
        }
        if (allDigits9) {
            int[] ans = new int[digits.length+1];
            ans[0]=1;
            for (int i=1; i<ans.length;i++){
                ans[i]=0;
            }
            System.out.println("done");
            return ans;
        }
        if (digits[digits.length-1]!=9) {
            digits[digits.length-1]=digits[digits.length-1]+1;
            return digits;
        }
        int i=digits.length-1;
        while (digits[i]==9){
                digits[i]=0;
                i--;
        }
        digits[i]= digits[i]+1;

        return digits;

    }
}
