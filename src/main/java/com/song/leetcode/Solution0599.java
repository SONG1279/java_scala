package com.song.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> l = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.get(list2[i]) != null) {
                if (map.get(list2[i]) + i < min) {
                    l.clear();
                    l.add(list2[i]);
                    min = map.get(list2[i]) + i;
                } else if (map.get(list2[i]) + i == min)
                    l.add(list2[i]);
            }
        }
        String[] s = new String[l.size()];
        for (int i = 0; i < l.size(); i++)
            s[i] = l.get(i);
        return s;
    }
}
