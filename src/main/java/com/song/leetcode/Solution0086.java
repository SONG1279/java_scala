package com.song.leetcode;

public class Solution0086 {
    public ListNode partition(ListNode head, int x) {

        ListNode small = new ListNode(0);
        ListNode smallTmp = small;
        ListNode big = new ListNode(0);
        ListNode bigTmp = big;

        while (head != null){

            if (head.val < x){

                smallTmp.next = head;
                head = head.next;
                smallTmp = smallTmp.next;
                smallTmp.next = null;

            }else {

                bigTmp.next = head;
                head = head.next;
                bigTmp = bigTmp.next;
                bigTmp.next = null;


            }
        }

        smallTmp.next = big.next;
        return small.next;



    }
}
