package com.example.problemsolving.TwoPointers;

public class containerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,110,110,110,2,5,4,8,3,7}));
    }
    public static int maxArea(int[] height) {
        int left=0;
        int right = height.length-1;
        int maxArea=0;

        while(left<right){
            if(height[left]<height[right]) {
                maxArea=Math.max(maxArea, (right-left)*height[left]);
                left++;
            }
            else {
                maxArea=Math.max(maxArea, (right-left)*height[right]);
                right--;
            }
        }
        return maxArea;
    }
}
