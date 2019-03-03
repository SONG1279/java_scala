package com.song.leetcode;

public class Solution0303 {
}
class NumArray {


    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int result = 0;
        for (int a = i; a <= j; a++){
            result += nums[a];
        }
        return result;
    }
}
