package com.song.leetcode;

public class Solution0342 {

    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        while (true){
            if (num == 1) return true;
            if (num % 4 != 0) return false;
            num = num/4;
        }
    }

}
