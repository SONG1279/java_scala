package com.song.leetcode;

public class Solution0413 {

    public int numberOfArithmeticSlices(int[] A) {

        int result = 0;

        for (int i = 0; i < A.length - 2; i++) {

            int count = A[i + 1] - A[i];
            int j = i + 2;
            while (j < A.length && A[j] - A[j - 1] == count){
                result++;
                j++;
            }


        }
        return result;
    }

}
