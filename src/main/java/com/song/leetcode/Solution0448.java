package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution0448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = 0 - Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) result.add(i+1);
        }
        return result;

    }

}
