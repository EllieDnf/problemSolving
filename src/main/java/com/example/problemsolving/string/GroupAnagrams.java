package com.example.problemsolving.string;

import java.util.*;
import java.util.stream.Stream;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer,Integer> frequency = new HashMap<>();
        for(int x: nums ){
           if (!frequency.containsKey(x)) frequency.put(x,1);
           else frequency.put(x,frequency.get(x)+1);
        }
        Integer [] values = (Integer[]) frequency.values().stream().sorted().toArray();

        int i=0;
        while (i<=k){
           // if
        }
        return ans;
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (groups.containsKey(key)) groups.get(key).add(s);
            else groups.put(key, new ArrayList<>(Arrays.asList(s)));
        }

        for (String key : groups.keySet()) {
            ans.add(groups.get(key));
        }
        return ans;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {

        List<List<String>> ans = new ArrayList<>();

        List<String> strsList = new ArrayList<>();

        for (String s : strs) {
            strsList.add(s);
        }

        while (!strsList.isEmpty()) {
            List<String> group = new ArrayList<>();
            String s = strsList.get(0);
            group.add(s);
            strsList.remove(0);
            for (int j = 0; j < strsList.size(); j++) {
                String t = strsList.get(j);
                if (isAnagram2(s, t)) {
                    group.add(t);
                    strsList.remove(j);
                    j--;
                }
            }
            ans.add(group);
        }
        return ans;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] stringS = s.toCharArray();
        char[] stringT = t.toCharArray();
        Arrays.sort(stringS);
        Arrays.sort(stringT);
        for (int i = 0; i < s.length(); i++) {
            if (stringS[i] != stringT[i]) return false;
        }
        return true;
    }
}
