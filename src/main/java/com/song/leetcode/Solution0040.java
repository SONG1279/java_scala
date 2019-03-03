package com.song.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution0040 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        Stack<Integer> stack = new Stack<>();
        putStack(candidates, stack, 0, target);
        return result;

    }

    public void putStack(int[] candidates, Stack<Integer> stack, int i, int target) {

        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) continue;
            if (target > candidates[j]) {
                stack.push(candidates[j]);
                putStack(candidates, stack, j + 1, target - candidates[j]);
                stack.pop();
            } else if (target == candidates[j]) {
                stack.push(candidates[j]);
                result.add(new ArrayList<>(stack));
                stack.pop();
            } else {
                break;
            }
        }

    }

}
