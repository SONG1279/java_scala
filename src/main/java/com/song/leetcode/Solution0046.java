package com.song.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0046 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> raw = new ArrayList<>();
        for (Integer n : nums) {
            raw.add(n);
        }
        List<Integer> now = new ArrayList<>();
        doit(now, raw);
        return result;
    }

    public void doit(List<Integer> now, List<Integer> left) {
        if (left.size() == 0) result.add(new ArrayList<>(now));
        for (int i = 0; i < left.size(); i++) {
            int a = left.remove(i);
            now.add(a);
            doit(now, left);
            left.add(i, a);
            now.remove(now.size() - 1);
        }

    }
}
































/*   public List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums){
            list.add(num);
        }
        result(list, 0);
        return lists;
    }

    public void result(List<Integer> list, int tmp){
        for (int i = tmp; i < list.size(); i++){
            int  a = list.remove(i);
            list.add(tmp, a);
            if (tmp < list.size() - 2){
                List<Integer> temp1 = new ArrayList<Integer>();
                for(int j = 0; j < list.size(); j++){
                    temp1.add(j, list.get(j));
                }
                result(temp1, tmp + 1);
            }else{
                List<Integer> temp = new ArrayList<Integer>();
                for(int j = 0; j < list.size(); j++){
                    temp.add(j, list.get(j));
                }
                lists.add(temp);
            }

        }
    }*/
