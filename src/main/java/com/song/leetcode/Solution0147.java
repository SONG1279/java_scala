package com.song.leetcode;

import com.song.algorithms.algs4.Stack;

public class Solution0147 {

    public ListNode insertionSortList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = new ListNode(Integer.MIN_VALUE);
        tmp.next = head;
        stack.push(tmp);
        while (head != null){

            if (head.val > stack.peek().val){
                stack.push(head);
                head = head.next;
            } else {

                head = stack.pop();
                ListNode tmp1 = head.next;
                head.next = tmp1.next;
                tmp1.next = head;
                stack.peek().next = tmp1;
                head = tmp1;





            }



        }

        return tmp.next;


    }



}
