package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution0094 {

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root != null) {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;

    }

    /*
    *
    * public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    list.add(cur.val);
                    cur = cur.right;
                }
            }
            return list;
        }
    * */

}
