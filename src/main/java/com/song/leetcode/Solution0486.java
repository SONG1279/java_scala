package com.song.leetcode;

public class Solution0486 {

    public boolean PredictTheWinner(int[] nums) {

        int sum = 0;
        for (int n : nums){
            sum += n;
        }
        int first = get(nums, 0, nums.length - 1);
        return first >= sum - first;
    }

    public int get(int[] nums, int i, int j){
        if (i == j) {
            return nums[i];
        }

        if (i + 1 == j){
            return  Math.max(nums[i], nums[j]);
        }

        return Math.max(nums[i] + Math.min(get(nums, i + 1, j - 1),get(nums, i + 2, j)),
                nums[j]+ Math.min(get(nums, i, j - 2),get(nums, i+ 1, j - 1)));

    }


    /*
    *
    * public boolean PredictTheWinner(int[] nums) {
        int size = nums.length;
        if(size % 2 == 0){
            return true;
        }
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            dp[i][i] = nums[i];
        }
        for (int l = 2; l <= size; l++) {
            for (int i = 0; i <= size - l; i++) {
                int j = i + l - 1;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][size - 1] >= 0;
    }
    *
    * */
}
