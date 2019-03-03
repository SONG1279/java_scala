package com.song.leetcode;

public class Solution0461 {
    public int hammingDistance(int x, int y) {

       /* int result = 0;
        int tmp = 1;
        while (tmp != 0){

            if ((x & tmp) != (y & tmp)){
                result++;
            }
            tmp = tmp << 1;
        }
        return result;*/

        return Integer.bitCount(x ^ y);
    }
}
