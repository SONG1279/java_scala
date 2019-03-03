package com.song.leetcode;

public class Solution0121 {

    public int maxProfit(int[] prices) {
        int max = 0;
        int tmp = 0;
        for (int i = 1; i < prices.length; i++) {
            tmp = Math.max(0,prices[i] - prices[i - 1] + tmp);
            max = Math.max(max, tmp);
        }
        return max;
    }


}
