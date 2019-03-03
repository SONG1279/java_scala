package com.song.leetcode;

public class Solution0050 {
    public double myPow(double x, int n) {
        double res = 1.0;
        while (n != 0){
            if (n % 2 != 0) res *= x;
            x *= x;
            n /= 2;
        }
        return n < 0 ? 1 / res : res;
    }
}
