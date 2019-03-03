package com.song.leetcode;


public class Solution0007 {
    public int reverse(int x) {
        int tmp = x < 0 ? -x : x;
        int result = 0;
        while (tmp != 0){
            if (Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE - tmp % 10 < result * 10 ) return 0;
            result *= 10;
            result += tmp % 10;
            tmp /= 10;
        }
        return x < 0 ? -result : result;
    }
}














