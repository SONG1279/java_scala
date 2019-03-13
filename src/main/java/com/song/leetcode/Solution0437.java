package com.song.leetcode;

public class Solution0437 {
    int result = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        getSum(root, sum);
        pathSum(root.right, sum);
        pathSum(root.left, sum);

        return result;
    }

    public void getSum(TreeNode root, int sum){
        if (root == null) {
            return;
        }
        if (sum - root.val == 0){
            result++;
        }
        getSum(root.left, sum - root.val);
        getSum(root.right, sum - root.val);

    }
}
