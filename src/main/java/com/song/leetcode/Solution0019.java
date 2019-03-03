package com.song.leetcode;

import java.util.List;

public class Solution0019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while (n != 0){
            fast = fast.next;
            n--;
        }
        if (fast == null) return head.next;
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }

/*
* 以前解法也不错
*  public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap();
        ListNode temp = head;
        int key = 0;
        while(temp != null){
            map.put(key++, temp);
            temp = temp.next;
        }
        int tmp = key - n;
        if (tmp < 0) return null;
        if (tmp == 0){
            head = head.next;
            return head;
        }
        ((ListNode) map.get(tmp - 1)).next = ((ListNode) map.get(tmp)).next;
        return head;


    }
* */
}
