package com.song.leetcode;

public class Solution0319 {

    public int bulbSwitch(int n) {

        if (n < 1) return 0;

        int result = 0;
        int a = 1;
        while (a <= n){

            result++;
            a *= a;
        }

        return result;

    }

}
