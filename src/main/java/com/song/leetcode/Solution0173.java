package com.song.leetcode;

import java.util.Stack;

public class Solution0173 {
}


class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {

            stack.push(root);
            root = root.left;

        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode tmp = stack.pop();
        TreeNode tmp1 = tmp.right;
        while (tmp1 != null) {
            stack.push(tmp1);
            tmp1 = tmp1.left;
        }

        return tmp.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
