package com.song.leetcode;

public class Solution0337 {

    public int rob(TreeNode root) {
        int[] rob = help(root);
        return Math.max(rob[0], rob[1]);
    }

    public int[] help(TreeNode root){

        if (root == null){
            return new int[2];
        }
        int[] left = help(root.left);
        int[] right = help(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;




    }

}
