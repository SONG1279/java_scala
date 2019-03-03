package com.song.leetcode;

public class Solution0143 {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;

        ListNode tmp = null;
        ListNode before = fast;
        ListNode after = null;
        while (before != null){
            after = before.next;
            before.next = tmp;
            tmp = before;
            before = after;
        }

        fast = tmp;
        slow = head;
        before = new ListNode(0);

        while (slow != null){

            before.next = slow;
            before = before.next;
            slow = slow.next;
            if (fast != null){
                before.next = fast;
                before = before.next;
                fast = fast.next;
            }




        }

    }

}
