package com.song.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


//不能用39和40题方法， 非常慢
public class Solution0077 {
/*

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        back(res, temp, 0, k, n);
        return res;
    }

    public void back(List<List<Integer>> res, List<Integer> temp, int start, int remain, int n) {
        if (remain == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start + 1; i <= n - remain + 1; i++) {
            temp.add(i);
            back(res, temp, i, remain - 1, n);
            temp.remove(temp.size() - 1);
        }
    }
*/




    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();

        putStack(result,n, 1, k, stack);

        return result;

    }

    public void putStack(List<List<Integer>> result,int n, int now, int k, List<Integer> stack) {

        if (k == 0) {
            result.add(new ArrayList<>(stack));
            return;

        }

        for (int i = now; i <= n; i++) {

            stack.add(i);
            putStack(result,n, i + 1, k - 1, stack);
            stack.remove(stack.size() - 1);


        }

    }
}
