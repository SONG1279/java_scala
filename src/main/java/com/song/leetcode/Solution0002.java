package com.song.leetcode;

public class Solution0002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tmep = head;
        int up = 0;
        while (l1 != null || l2 != null){
            int tmp = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + up;
            up = tmp / 10;
            tmp = tmp % 10;
            tmep.next = new ListNode(tmp);
            tmep = tmep.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (up == 1) tmep.next = new ListNode(1);
        return head.next;
    }
}
