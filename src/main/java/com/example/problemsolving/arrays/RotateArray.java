package com.example.problemsolving.arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate (new int[]{-1,2},3)));
    }
    public static int[] rotate(int[] nums, int k) {
        if(nums.length<2) return nums;
        k=k%nums.length;
        int [] partially = new int[k];
        int j=0;
        for(int i=nums.length-k ; i<nums.length;i++){
            partially[j]=nums[i];
            j++;
        }
        j=nums.length-1;
        for (int i=nums.length-k-1 ; i>=0;i--){
            nums[j]=nums[i];
            j--;
        }
        int idx=0;
        for (int x:partially){
            nums[idx]=x;
            idx++;
        }
        return nums;
    }
}
