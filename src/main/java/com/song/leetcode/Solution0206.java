package com.song.leetcode;

public class Solution0206 {
    public ListNode reverseList(ListNode head) {
        ListNode tmp = head;
        ListNode before = null;
        while (tmp != null){
            tmp = head.next;
            head.next = before;
            before = head;
            head = tmp;
        }
        return before;

    }
}
