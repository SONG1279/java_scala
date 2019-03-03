package com.song.leetcode;

import com.song.algorithms.algs4.Stack;

public class Solution0020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != 'c') return false;
        }
        return stack.isEmpty();

    }


}
