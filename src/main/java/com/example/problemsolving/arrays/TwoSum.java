package com.example.problemsolving.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) return new int[]{map.get(x), i};
            else map.put(nums[i], i);
        }
        return null;
//       int[] ans = new int[2];
//        for (int i=0;i<nums.length;i++){
//            for (int j=i+1 ; j<nums.length;j++){
//                if (nums[i]+nums[j]==target) return new int[]{i,j};
//            }
//        }
//        return ans;
    }
}
