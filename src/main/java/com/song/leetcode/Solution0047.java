package com.song.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0047 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> raw = new ArrayList<>();
        for (Integer n : nums) {
            raw.add(n);
        }
        List<Integer> now = new ArrayList<>();
        doit(now, raw);
        return result;



    }

    public void doit(List<Integer> now, List<Integer> left) {
        if (left.size() == 0) result.add(new ArrayList<>(now));
        for (int i = 0; i < left.size(); i++) {
            if (i > 0 && left.get(i).equals(left.get(i - 1))) continue;

            int a = left.remove(i);

            now.add(a);
            doit(now, left);
            left.add(i, a);
            now.remove(now.size() - 1);
        }

    }
}
