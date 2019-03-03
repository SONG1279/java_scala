package com.song.leetcode;

public class Solution0136 {
    public int singleNumber(int[] nums) {

        int result = 0;
        for(int i : nums){
            result ^= i;
        }
        return result;

    }
}
