package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution0229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        if (nums.length == 0) return list;

        int a = nums[0];
        int b = nums[0];
        int countA = 0;
        int countB = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a) countA++;
            else if (nums[i] == b) countB++;
            else if ( countA== 0) {
                countA = 1;
                a = nums[i];
            } else if (countB == 0) {
                countB = 1;
                b = nums[i];
            } else {
                countA--;
                countB--;
            }
        }
        countA = 0;
        countB = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a) countA++;
            if (nums[i] == b) countB++;
        }
        if (countA > nums.length / 3){
            list.add(a);
        }

        if (countB > nums.length / 3 && a != b){
            list.add(b);
        }
        return list;


    }

}
