package com.example.problemsolving.arrays;

import java.util.Arrays;

public class LongestConsecutive {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length < 2) return nums.length;

        Arrays.sort(nums);

        int max = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int consequtive = 1;
            while (nums[i] + 1 == nums[i + 1] || nums[i] == nums[i + 1]) {
                if (nums[i] + 1 == nums[i + 1]) {
                    consequtive++;
                    i++;
                } else if (nums[i] == nums[i + 1]) i++;
                if (i == nums.length - 1) break;
            }
            max = Math.max(max, consequtive);
        }
        return max;
    }
}
