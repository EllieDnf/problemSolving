package com.example.problemsolving.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqueChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcodelove"));
    }
    public static int firstUniqChar(String s) {
        Map<Integer, Character> map = new HashMap();
        for (int i=0;i<s.length();i++) {
            map.put(i, s.charAt(i));
        }
        for (int i=0; i<s.length();i++){
            map.remove(i);
            if (!map.containsValue(s.charAt(i))) return i;
            else map.put(i, s.charAt(i));
        }
        return -1;
    }
}
