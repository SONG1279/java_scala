package com.song.leetcode;

public class Solution0210 {

    public int rangeBitwiseAnd(int m, int n) {
       /* int result = m;
        for (int i = m + 1; i <= n; i++) {
            result = result & i;
            if (result == 0) return 0;
        }
        return result;*/

        int count = 0;
        while (m != n) {
            //右 移1位后判断
            m >>= 1;
            n >>= 1;
            count++;
        }
        return n << count;
    }

    /* int count = 0;
        while (m != n) {
            //右移1位后判断
            m >>= 1;
            n >>= 1;
            count++;
        }
        return n << count;
    }*/

    public static void main(String[] args) {
        new Solution0210().rangeBitwiseAnd(1,4);
    }
}
