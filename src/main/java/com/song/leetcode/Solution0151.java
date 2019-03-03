package com.song.leetcode;

public class Solution0151 {
        public String reverseWords(String s) {
            String str = s.trim();
            StringBuilder sb = new StringBuilder();
            int tmp = str.length();
            for (int i = str.length() - 1; i >= 0; i--) {
                if (str.charAt(i) == ' '){
                    if (i + 1 == tmp) {

                        tmp = i;
                        continue;
                    }
                    sb.append(str.subSequence(i + 1, tmp));
                    sb.append(' ');
                    tmp = i;
                }
                if (i == 0){
                    sb.append(str.substring(0, tmp));
                }
            }
            return sb.toString();
        }
}
