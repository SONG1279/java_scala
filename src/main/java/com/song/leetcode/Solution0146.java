package com.song.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution0146 {
}
class LRUCache {
    Map<Integer, Integer> cache;
    int cap;
    public LRUCache(int capacity) {
        cap = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity, 1, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry oldest) {
                return cache.size() > cap;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}