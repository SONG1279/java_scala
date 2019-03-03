package com.song.leetcode;

public class Solution0021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return  (l1 == null) ? l2 : l1;
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (l1 != null || l2 != null){
            if (l1.val < l2.val) {
                tmp.next = l1;
                tmp = tmp.next;
                if (l1.next == null) {
                    tmp.next = l2;
                    break;
                }
                l1 = l1.next;
            } else {
                tmp.next = l2;
                tmp = tmp.next;
                if (l2.next == null) {
                    tmp.next = l1;
                    break;
                }
                l2 = l2.next;
            }
        }
        return head.next;

    }
}

