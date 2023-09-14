package com.example.problemsolving.arrays;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
    }
    public static int singleNumber(int[] nums) {
//?????????
        int temp=0;
        for(int i=0;i<nums.length;i++){
            temp=temp^nums[i];
        }
        return temp;
//        Set <Integer> a = new HashSet<>();
//        for (int x: nums) {
//           if(!a.add(x)) a.remove(x);
//        }
//        int x = nums[0];
//        for (Integer i:a) {
//            x=i;
//        }
//        return x;
    }
}
