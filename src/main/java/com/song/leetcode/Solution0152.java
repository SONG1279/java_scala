package com.song.leetcode;

public class Solution0152 {
    public int maxProduct(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int result = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                max = nums[i];
                break;
            }
        }
        int minmax = nums[0];
        int start = 0;
        int end = 0;

        while (end < nums.length) {
            if (nums[end] == 0) {
                start = end + 1;
                end = end + 2;
                if (start < nums.length) max = nums[start];
            } else {

                if (nums[end] < 0 && minmax > 0) {
                    minmax *= nums[end];
                } else {

                    minmax *= nums[end];
                    max = minmax;
                }


            }

            result = Math.max(result, max);


        }
        return result;
    }
}
