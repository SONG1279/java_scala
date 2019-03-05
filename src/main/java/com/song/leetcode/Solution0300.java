package com.song.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0300 {
    public int lengthOfLIS(int[] nums) {
        /*
         dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
         由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
         对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
         1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
         数组尾部, 并将最长递增序列长度maxL加1
         2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
         **/

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){

                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }
            }
        }
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
