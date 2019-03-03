package com.song.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution0219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i], i);
            } else {

                int a = map.get(nums[i]);
                if (Math.abs(a - i) <= k) return true;
                map.put(nums[i], i);

            }

        }
        return false;


    }
}
