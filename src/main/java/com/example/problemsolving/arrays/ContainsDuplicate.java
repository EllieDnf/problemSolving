package com.example.problemsolving.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
        //low speed
//        int[] a =Arrays.stream(nums).sorted().toArray();
//        for(int i=0; i<nums.length-1;i++){
//            if(a[i]==a[i+1]) return true;
//        }
//        return false;
//        HashSet<Integer> set = new HashSet<>();
//        for (int element : nums) {
//            set.add(element);
//        }
//        return nums.length==set.size();
    }
}
