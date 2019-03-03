package com.song.leetcode;

public class Solution0105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int first1, int last1, int first2, int last2){
        if (first1 > last1 || first2 > last2) return null;
        TreeNode root = new TreeNode(preorder[first1]);
        int i = first2;
        while (inorder[i] != preorder[first1]) i++;
        root.left = build(preorder, inorder, first1 + 1, first1 + i - first2, first2, i - 1);
        root.right = build(preorder, inorder, first1 + i - first2 + 1, last1, i + 1, last2);
        return root;


    }
}
