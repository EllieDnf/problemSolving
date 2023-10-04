package com.example.problemsolving.binarySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            TreeMap<Integer, String> timestamps = map.get(key);
            Integer floorKey = timestamps.floorKey(timestamp);
            if (floorKey != null) {
                return timestamps.get(floorKey);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("a", "bar", 1);
        timeMap.set("x", "b", 3);
        System.out.println(timeMap.get("b", 3)); // Output: "bar1"
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4)); // Output: "bar2"
        System.out.println(timeMap.get("foo", 5)); // Output: ""
    }
}
