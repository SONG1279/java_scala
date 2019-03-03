package com.song.leetcode;

public class Solution0404 {
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {

        sum = 0;
        if (root == null){
            return sum;
        }

        getRight(root);
        return sum;

    }

    public void getLeft(TreeNode root){

        if (root.left != null){
            getLeft(root.left);
        }

        if (root.right!= null){
            getRight(root.right);
        }


        if (root.right == null && root.left == null){
            sum += root.val;
        }

    }
    public void getRight(TreeNode root){

        if (root.left != null){
            getLeft(root.left);
        }
        if (root.right != null){
            getRight(root.right);
        }

    }
}
