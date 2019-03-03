package com.song.leetcode;

import java.util.Arrays;

public class Solution0567 {
    public boolean checkInclusion(String s1, String s2) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        String ss1 = String.valueOf(chars) ;

        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {

            char[] a = s2.substring(i, s1.length()).toCharArray();
            Arrays.sort(a);
            if (String.valueOf(a).equals(ss1))return true;

        }
        return false;


    }
    /*
    *我的慢死了
    * public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for(char c : s1.toCharArray())
            c1[c-'a']++;

        for (int i = 0; i < l2; i++) {
            if (i >= l1)
                --c2[s2.charAt(i - l1) - 'a'];
            c2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(c1, c2))
                return true;
        }
        return false;
    }
    * */
}
