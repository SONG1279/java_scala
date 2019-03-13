package com.song.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution0199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        TreeNode cur = root;
        queue.add(cur);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (size == 1) {
                    res.add(cur.val);
                }
                size--;
            }
        }
        return res;
    }
}
