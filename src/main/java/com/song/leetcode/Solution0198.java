package com.song.leetcode;

public class Solution0198 {

    public int rob(int[] nums) {

        int pre1 = 0;
        int pre2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int current = pre1 + nums[i] > pre2 ? pre1 + nums[i] : pre2;
            pre1 = pre2;
            pre2 = current;

        }

        return pre2;

    }

}
