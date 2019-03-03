package com.song.leetcode;

public class Solution0213 {



    public int rob(int[] nums) {

        if (nums.length == 1) return nums[0];

        int pre1 = 0;
        int pre2 = 0;
        int pre3 = 0;
        int pre4 = 0;
        int current1 = 0;
        int current2 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            current1 = pre1 + nums[i] > pre2 ? pre1 + nums[i] : pre2;
            pre1 = pre2;
            pre2 = current1;

            current2 = pre3 + nums[i + 1] > pre4 ? pre3 + nums[i + 1] : pre4;
            pre3 = pre4;
            pre4 = current2;
        }

        return Math.max(current1, current2);

    }

}
