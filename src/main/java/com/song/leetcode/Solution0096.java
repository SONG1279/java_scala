package com.song.leetcode;

public class Solution0096 {
    public int numTrees(int n) {
        /**
         搜索二叉树的定义是，对于任意一个节点来说，其左子树上的所有节点小于其右子树上任意节点。
         比如[1,2,3,4,5],若是以3为根结点，其左字树元素只能是[1,2]（化为求两个元素的问题），
         右子树元素只能是[4,5]（同样化为求两个元素的问题）。
         到这里就可以dp打表解决问题了。
         */

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n ; i++) {
            int count = 0;
            for (int j = 1; j <= i ; j++) {
                int L = dp[j - 1];
                int R = dp[i - j];
                count += (L != 0 && R != 0) ? L * R : L + R;

            }
            dp[i] = count;
        }

        return dp[n];

    }
}
