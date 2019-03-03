package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;


//这题有点忘了
public class Solution0022 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        getStrings(result, "",0, 0, n);
        return result;
    }
    public void getStrings(List<String> list, String str, int open, int close, int max) {
        if (str.length() == 2 * max) {
            list.add(str);
        }
        if (open < max) {
            getStrings(list, str + '(', open + 1, close, max);
        }
        if (close < open) {
            getStrings(list, str + ')', open, close + 1, max);
        }
    }
}
