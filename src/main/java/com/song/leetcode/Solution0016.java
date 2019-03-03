package com.song.leetcode;

import java.util.Arrays;

public class Solution0016 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;

            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(sum - target) < min) {
                    result = sum;
                    min = Math.abs(sum - target);
                }
                if (sum > target) hi--;
                if (sum < target) lo++;
                if (sum == target) return result;

            }
        }
        return result;
    }


}
