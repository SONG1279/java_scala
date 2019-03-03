package com.song.leetcode;

/*给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"*/

public class Solution0005 {
    //我的方法太慢了
    public String longestPalindrome(String s) {
        int max = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int x = 0;
            while (i - x > 0 && i + x < s.length() - 1) {
                if (s.charAt(i - x - 1) == s.charAt(i + x + 1)) x += 1;
                else break;
            }
            if (max < 2 * x + 1) {
                max = 2 * x + 1;
                result = s.substring(i - x, i + x + 1);
            }
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)){
                int b = 1;
                while (i - x > 0 && i + x + 1 < s.length() - 1){
                    if (s.charAt(i - x - 1) == s.charAt(i + x + 2)) b+= 1;
                    else break;
                }
                if (max < 2 * b){
                    max = 2 * b;
                    result = s.substring(i - x, i + x + 2);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("aaaa".substring(1-2+1,1+1+2));
    }
}

/*
    private int begin;
    private int length;
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2)
            return s;
        for(int i = 0; i < len; i++){
            whatWeGonnaDo(s, i, i);
            whatWeGonnaDo(s, i, i + 1);
        }
        return s.substring(begin, begin + length);
    }
    public void whatWeGonnaDo(String str, int j, int k){
        while(j >= 0 && k < str.length() && str.charAt(j) == str.charAt(k)){
            j--;
            k++;
        }
        if(length < k - j - 1){
            begin = j + 1;
            length = k - j - 1;
        }
    }*/
