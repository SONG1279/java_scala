package com.song.leetcode;

import java.math.BigDecimal;

public class Solution0268 {

    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result + i - nums[i];

        }
        return result + nums.length;
    }

}
