package com.song.leetcode;

public class Solution0006 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuffer sb = new StringBuffer("");
        int length = s.length(), dis = (numRows - 1) * 2;
        for (int i = 0; i < numRows; i++) {
            int tmp = i;
            int first = dis - i * 2;
            int secend = dis - first;
            boolean flag= true;
            while (tmp < length){
                sb.append(s.charAt(tmp));
                if (first ==0 )tmp += secend;
                else if (secend == 0) tmp += first;
                else {
                    if (flag)tmp += first;
                    else tmp+=secend;
                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }

}
