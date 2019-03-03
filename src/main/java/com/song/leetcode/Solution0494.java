package com.song.leetcode;

public class Solution0494 {
    public int findTargetSumWays(int[] nums, int S) {

        return findit(nums, S, 0, 0);

    }

    public int findit(int[] nums, int S, int sum, int index) {
        int res = 0;
        if (index == nums.length) {
            return S == sum ? 0 : 1;
        }

        res += findit(nums,S, sum + nums[index], index + 1);
        res += findit(nums, S, sum - nums[index], index+ 1);

        return  res;

    }
}
