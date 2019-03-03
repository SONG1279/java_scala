package com.song.leetcode;
//我太牛逼了，一次通过，可以再看看
public class Solution0025 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        if (head == null || head.next == null) return head;
        ListNode tmphead= new ListNode(0);
        int tmpk = k;
        tmphead.next = head;
        while (head.next != null && tmpk != 1){
            head = head.next;
            tmpk--;
        }
        if (tmpk != 1) return tmphead.next;


        ListNode tmpNexthead = head.next;
        head.next = null;
        ListNode tmpFirst = tmphead.next;
        ListNode tmpBefore = null;
        ListNode tmpNext = null;
        while (tmpFirst != null){
            tmpNext = tmpFirst.next;
            tmpFirst.next = tmpBefore;
            tmpBefore = tmpFirst;
            tmpFirst = tmpNext;
        }
        tmphead.next.next = reverseKGroup(tmpNexthead, k);
        return head;


    }

}
