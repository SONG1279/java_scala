package com.song.leetcode;

public class Solution0230 {
    public int kthSmallest(TreeNode root, int k) {
        ktemp = k;
        dfs(root);
        return ans;
    }

    private int ans = 0;
    private int ktemp = 0;

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (--ktemp == 0) {
            ans = node.val;
            return;
        }
        dfs(node.right);
    }
}
