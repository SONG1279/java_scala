package com.song.leetcode;

public class Solution0111 {

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth =  minDepth(root.left);
        int rightDepth =  minDepth(root.right);
        int min = Math.min(leftDepth, rightDepth);
        return min == 0 ? Math.max(leftDepth, rightDepth) + 1 : min + 1;
    }

}
