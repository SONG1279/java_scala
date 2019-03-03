package com.song.leetcode;

public class Solution0450 {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root.val == key){

            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode tmp  = root.right;
            while (tmp.left != null){
                tmp = tmp.left;
            }
            tmp.left = root.left;
            return root.right;
        }

        if (root.val > key){

            root.left = delete(root.left, key);
        }else {
            root.right = delete(root.right, key);
        }

        return root;
    }

    public TreeNode delete(TreeNode root, int key){
        if (root == null) return null;
        if (root.val == key){

            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode tmp  = root.right;
            while (tmp.left != null){
                tmp = tmp.left;
            }
            tmp.left = root.left;
            return root.right;

        }
        if (root.val > key){

            root.left = delete(root.left, key);
        }else {
            root.right = delete(root.right, key);
        }

        return root;
    }
}
