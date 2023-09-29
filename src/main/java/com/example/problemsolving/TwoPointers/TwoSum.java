package com.example.problemsolving.TwoPointers;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 24, 50, 79, 88, 150, 345}, 200)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) return new int[]{left + 1, right + 1};
            else if (numbers[left] + numbers[right] < target) left++;
            else right--;
        }
        return null;
    }
}
