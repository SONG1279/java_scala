package com.song.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution0095 {
    public List<TreeNode> generateTrees(int n) {

        if(n == 0) {
            return null;
        }
        return generateTrees(1, n);

    }

    public List<TreeNode> generateTrees(int start, int end){

        List<TreeNode> res = new LinkedList<>();
        if (start > end){
            res.add(null);
            return res;
        }

        for (int i = start; i <= end ; i++) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            for (TreeNode l : left){
                for (TreeNode r : right){

                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    res.add(node);

                }
            }


        }
        return res;

    }
}
