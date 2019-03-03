package com.song.leetcode;

public class Solution0246 {

    public int nthUglyNumber(int n) {

        int[] arr = new int[n];
        arr[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            arr[i] = min;
            if (factor2 == min) factor2 = 2 * arr[++index2];
            if (factor3 == min) factor3 = 3 * arr[++index3];
            if (factor5 == min) factor5 = 5 * arr[++index5];

        }
        return arr[n - 1];
    }

}


class Solution {
    public int FirstNotRepeatingChar(String str) {
        char[] chars = new char[128];

        for (char a : str.toCharArray()){
            chars[a]++;

        }


        int i = 0;
        for (char a : str.toCharArray()) {


            if (chars[a] == 1) return i;
            i++;
        }
        return -1;
    }
}
