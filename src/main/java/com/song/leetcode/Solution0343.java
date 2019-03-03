package com.song.leetcode;

public class Solution0343 {

    public int integerBreak(int n) {
        if (n <= 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int tmp = 1;
        while (n != 0){
            if (n  > 4 || n == 3){
                tmp *= 3;
                n -= 3;
            }else {
                tmp *= 2;
                n -= 2;
            }
        }
        return tmp;
    }

}
