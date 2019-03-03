package com.song.leetcode;

public class Solution0008 {

    public int myAtoi(String str) {
        int result = 0;
        int i = 0;
        boolean positive = true;
        boolean canbe = true;
        while (i < str.length()) {
            if (str.charAt(i) == ' ') {
                if (!canbe) break;
            } else if (str.charAt(i) == '+') {
                if (!canbe) break;
                positive = true;
                canbe = false;
            } else if (str.charAt(i) == '-') {
                if (!canbe) break;
                positive = false;
                canbe = false;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                canbe = false;
                if (Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE - (str.charAt(i) - '0') < result * 10)
                    return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                result *= 10;
                result += str.charAt(i) - '0';
            } else {
                break;
            }

            i++;


        }


        return positive ? result : -result;

    }


}
