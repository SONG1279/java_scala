package com.song.leetcode;

import java.util.Stack;

public class Solution0394 {
    public String decodeString(String s) {
        Stack<Integer> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        String sb = "";
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {

                cnt = cnt * 10 + s.charAt(i) - '0';

            } else if (s.charAt(i) == '[') {

                s1.push(cnt);
                s2.push(sb);
                cnt = 0;
                sb = "";

            } else if (s.charAt(i) == ']') {
                int k = s1.pop();
                String tmp = s2.pop();
                for (int j = 0; j < k; j++) {
                    tmp += sb;
                }
                sb = tmp;
            } else {
                sb += s.charAt(i);
            }
        }
        return sb;
    }
}
