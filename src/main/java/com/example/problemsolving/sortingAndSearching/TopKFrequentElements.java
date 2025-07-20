package com.example.problemsolving.sortingAndSearching;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,3}, 2)));
    }
    public static int[] topKFrequent(int[] nums, int k) {

        int[] ans = new int[k];

        Map<Integer,Integer> count= new HashMap<>();
        for (int num : nums){
            count.put(num, count.getOrDefault(num,0)+1);
        }

        List<Integer> valueList= new ArrayList<>(count.values());
        Collections.sort(valueList,Collections.reverseOrder());

        for (int i=0;i<k;i++) {
            for (Map.Entry<Integer, Integer> a : count.entrySet()) {
                if (a.getValue() == valueList.get(i)) {
                    ans[i] = a.getKey();
                    count.remove(a.getKey());
                    break;
                }
            }
        }
        return ans;
    }
}
