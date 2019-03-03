package com.song.leetcode;

public class Solution0024 {


    public ListNode swapPairs(ListNode head) {
        ListNode tmphead = new ListNode(0);
        tmphead.next = head;
        if (tmphead.next != null && tmphead.next.next != null) {
            exchange2(tmphead);
        }

        return tmphead.next;
    }

    public void exchange2(ListNode first) {

        ListNode tmp = first.next;
        first.next = first.next.next;
        tmp.next = first.next.next;
        first.next.next = tmp;
        if (tmp.next != null && tmp.next.next != null) {
            exchange2(tmp);
        }
    }
}

/* public ListNode swapPairs(ListNode head) {
        if (head == null) return head;

        ListNode lastNode = new ListNode(0);
        lastNode.next = head;
        head = lastNode;
        ListNode tmp = lastNode.next;
        while (tmp.next != null) {
            ListNode node = tmp.next.next;
            lastNode.next = tmp.next;
            tmp.next.next = tmp;
            tmp.next = node;
            lastNode = tmp;
            tmp = tmp.next;
            if (tmp == null) break;

        }
        return head.next;
    }*/
