package com.example.problemsolving.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(2147483412));
        System.out.println(reverse(1534236469));

    }
    public static int reverse(int x) {
        int sign = 1;
        if (x<0) {
            sign=-1;
            x=-x;
        }
        List<Integer> num = new ArrayList<>();
        while(x>0){
            num.add(x%10);
            x/=10;
        }
        int ans=0;
        int limit = (int)Math.pow(2,31)-1;

        for (int i=0;i<num.size();i++){
            ans=ans*10+num.get(i);
            if (i == num.size() - 2 && ans > ((int) Math.pow(2, 31) - 1) / 10) return 0;
        }
        return ans*sign;
    }
}
