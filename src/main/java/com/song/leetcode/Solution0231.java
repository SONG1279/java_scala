package com.song.leetcode;

public class Solution0231 {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        int a = n & (n - 1);
        return a == 0;

    }

    /*
    *   public boolean isPowerOfTwo(int n) {
if (n <= 0) return false;
        while (n!=0){
            if (n == 1) return true;
            if(n % 2 == 1) return false;
            n = n / 2;
        }
        return true;
    }
    * */

}
