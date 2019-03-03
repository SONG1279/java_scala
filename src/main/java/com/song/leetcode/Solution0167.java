package com.song.leetcode;

public class Solution0167 {


    public int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo < hi) {

            if (numbers[lo] + numbers[hi] < target) {
                lo++;
            } else if (numbers[lo] + numbers[hi] > target) {
                hi --;
            } else {
                result[0] = lo + 1;
                result[1] = hi + 1;
                return result;
            }


        }
        return result;

    }

}
