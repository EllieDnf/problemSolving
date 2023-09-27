package com.example.problemsolving.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2, 2})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            if (!map2.containsKey(nums2[i])) map2.put(nums2[i], 1);
            else map2.put(nums2[i], map2.get(nums2[i]) + 1);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (map2.containsKey(nums1[i])) {
                ans.add(nums1[i]);
                if (map2.get(nums1[i]) == 1) map2.remove(nums1[i]);
                else map2.put(nums1[i], map2.get(nums1[i]) - 1);
            }
        }
        int[] a = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            a[i] = ans.get(i);
        }
        return a;
    }
}
