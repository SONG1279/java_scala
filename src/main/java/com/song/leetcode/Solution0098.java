package com.song.leetcode;

public class Solution0098 {

    public int min = Integer.MIN_VALUE;
    boolean flag = true;

    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if ((root.val == min && flag) || root.val > min) {
            flag = false;
            min = root.val;

        } else {
            return false;
        }

        if (!isValidBST(root.right)) return false;
        return true;


    }
}
