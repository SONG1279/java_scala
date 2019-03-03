package com.song.leetcode;

public class Solution0003 {
    /*
    * 意思就是*/
    public int lengthOfLongestSubstring(String s) {

        int[] arr = new int[128];
        int result = 0;
        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)] != 0) tmp = Math.max(tmp, arr[s.charAt(i)]);
            arr[s.charAt(i)] = i + 1;
            result = Math.max(result, i + 1 - tmp);
        }
        return result;
    }
}
