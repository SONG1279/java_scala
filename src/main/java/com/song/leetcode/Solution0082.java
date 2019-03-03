package com.song.leetcode;

public class Solution0082 {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode before = tmp;
        while (head != null){

            if (head.next != null && head.val == head.next.val){
                while (head.next != null && head.val == head.next.val){
                    head.next = head.next.next;
                }
                before.next = head.next;
                head = before.next;
            }  else {
                before = before.next;
                head = head.next;
            }


        }

        return tmp.next;
    }
}
