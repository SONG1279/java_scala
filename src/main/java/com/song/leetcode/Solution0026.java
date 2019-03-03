package com.song.leetcode;



public class Solution0026 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int now = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > now){
                nums[index] = nums[i];
                now = nums[index];
                index++;
            }

        }
        return index;
    }

}
