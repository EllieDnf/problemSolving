package com.example.problemsolving.arrays;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] exp = new int[]{1, 1, 0, 3, 12, 0};
        moveZeroes(exp);
        System.out.println(Arrays.toString(exp));
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        i++;
                    }
                }
                while (i < nums.length) {
                    nums[i] = 0;
                    i++;
                }
            }
        }
    }
}
