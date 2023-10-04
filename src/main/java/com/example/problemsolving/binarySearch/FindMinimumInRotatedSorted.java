package com.example.problemsolving.binarySearch;

public class FindMinimumInRotatedSorted {
    public static void main(String[] args) {
        System.out.println(findMin(new int[] {1}));
    }
    public static int findMin(int[] nums) {
        int left =0;
        int right=nums.length-1;

        while(left<=right){
            int mid = (right+left)/2;
            if (nums[mid]>nums[right]) left=mid;
            else right =mid;
            if (left+1==right || left==right) break;
        }
        return Math.min(nums[left],nums[right]);
    }
}
