package com.song.leetcode;

import java.util.*;

public class Solution0402 {


    public String removeKdigits(String num, int k) {
        /**
         使用栈来暂存结果的值, 只要栈不为空且栈顶元素大于下一位的值就将栈顶元素舍弃并将k减1, 然后将新的较小值加入栈内(注意前导0情况要跳过)
         最后要考虑升序序列这种情况, k最后不为0, 需要将栈顶元素删除k次, 可以进一步用一个char数组来模拟栈来优化时间效率
         **/
        Stack<Character> q = new Stack<>();

        for (int i = 0; i < num.length(); i++) {

            char a = num.charAt(i);

            while (!q.isEmpty() && k > 0 && q.peek() > a) {
                q.pop();
                k--;
            }
            if (q.isEmpty() && a == '0') continue;

            q.push(a);

        }

        while (k-- > 0) {
            q.pop();

        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            sb.append(q.pop());
        }


        if (sb.length() == 0) return "0";
        return sb.reverse().toString();

    }

}
