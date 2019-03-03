package com.song.leetcode;

public class Solution0240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length <= 0 || matrix[0].length <= 0) return false;
        int m = 0;
        int n = matrix[0].length - 1;

        while (n >= 0 && m < matrix.length){

            if (matrix[m][n] < target) m++;
            else if (matrix[m][n] > target) n--;
            else if (matrix[m][n] == target) return true;


        }

        return false;


    }

}
