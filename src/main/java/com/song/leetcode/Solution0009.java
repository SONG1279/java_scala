package com.song.leetcode;

public class Solution0009 {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int lo = 0, hi = str.length() - 1;
        while (lo < hi){
            if (str.charAt(lo) == str.charAt(hi)){
                lo++;
                hi--;
            } else {
                return false;
            }
        }
        return true;
    }

    /*
    *  public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString().equals(str);
    }
    */
}
