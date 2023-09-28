package com.example.problemsolving.arrays;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }
    public static int[] productExceptSelf(int[] nums) {
        int[]ans= new int[nums.length];
        int countZero=0;
        int idxZero=-1;
        for (int i=0; i<ans.length;i++){
            if (nums[i]==0) {
                countZero++;
                idxZero=i;
            }
            if (countZero>1) return ans;
        }
        if(countZero==1) {
            ans[idxZero] =productExceptIdx(nums,idxZero);
            return ans;
        }
        for(int i=0; i<nums.length;i++){
            ans[i]= product(nums)/nums[i];
        }
        return ans;
    }

    public static int product (int[] nums){
        int product=1;
        for (int i=0; i<nums.length ;i++){
            product=product*nums[i];
        }
        return product;
    }

    public static int productExceptIdx (int[] nums, int idx){
        int product=1;
        for (int i=0; i<nums.length ;i++){
            if (i==idx && i!=nums.length-1) i++;
            if (i==idx && i==nums.length-1) return product;
            product=product*nums[i];
        }
        return product;
    }
}
