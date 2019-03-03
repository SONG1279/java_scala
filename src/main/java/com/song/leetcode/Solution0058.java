package com.song.leetcode;

public class Solution0058 {

    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;

        String[] str = s.split(" ");
        if (str.length > 0) return str[str.length - 1].length();
        return 0;


    }


}
