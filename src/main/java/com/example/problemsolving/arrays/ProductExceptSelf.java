package com.example.problemsolving.arrays;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];

        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }

        rightProducts[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = rightProducts[i] * leftProducts[i];
        }
        return ans;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int[] ans = new int[nums.length];
        int countZero = 0;
        int idxZero = -1;
        for (int i = 0; i < ans.length; i++) {
            if (nums[i] == 0) {
                countZero++;
                idxZero = i;
            }
            if (countZero > 1) return ans;
        }
        if (countZero == 1) {
            ans[idxZero] = productExceptIdx(nums, idxZero);
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = productExceptIdx(nums, i);
        }
        return ans;
    }

    public static int productExceptIdx(int[] nums, int idx) {
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == idx && i != nums.length - 1) i++;
            if (i == idx && i == nums.length - 1) return product;
            product = product * nums[i];
        }
        return product;
    }
}
