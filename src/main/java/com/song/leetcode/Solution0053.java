package com.song.leetcode;

public class Solution0053 {

    public boolean canJump(int[] nums) {

        if (nums.length == 0) return false;
        int start = 1;
        for (int i = 0; i < nums.length; i++) {
            start -= 1;
            start = Math.max(start,nums[i]);
            if (start <= 0) return false;
        }
        return true;


    }

}
