package com.song.leetcode;

import java.util.*;

public class Solution0451 {
    public String frequencySort(String s) {

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list, (o1 , o2) -> o2.getValue() - o1.getValue() );
        StringBuilder sb = new StringBuilder("");
        list.forEach(a -> {
            for (int i = 0; i < a.getValue(); i++) sb.append(a.getKey());
        });
        return sb.toString();


    }
}
