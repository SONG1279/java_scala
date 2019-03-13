package com.song.leetcode;

public class Solution0168 {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        int s1 = 0;
        while(n != 0){
            s1 = (n - 1) % 26;
            n = (n - s1) / 26;
            sb.append((char)(s1 + 'A'));
        }
        return sb.reverse().toString();
    }
}
