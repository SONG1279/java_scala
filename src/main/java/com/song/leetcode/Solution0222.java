package com.song.leetcode;

public class Solution0222 {
    public int countNodes(TreeNode root) {
        return root == null ? 0 : countNodes(root.right) + countNodes(root.left) + 1;
    }
}
