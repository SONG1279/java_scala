package com.song.leetcode;

public class Solution0028 {

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        int length = haystack.length() - needle.length();
        for (int i = 0; i <= length; i++) {
            if (haystack.charAt(i) == needle.charAt(0)){
                boolean flag = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)){
                        flag = false;
                        break;
                    }

                }
                if (flag) return i;
            }
        }
        return  -1;
    }




}
































/*public int strStr(String haystack, String needle) {

        if (needle.equals("")) return 0;
        if (!haystack.contains(needle)) return -1;
        char[] a = haystack.toCharArray();
        char[] b= needle.toCharArray();
        boolean flag;
        for (int i = 0; i < a.length; i++){
            flag = true;
            if (a[i] == b[0]){
                for (int j = 0; j < b.length; j++){
                    if (a[i + j] != b[j]) flag = false;
                }
                if (flag) return i;
            }
        }
        return -1;
    }*/