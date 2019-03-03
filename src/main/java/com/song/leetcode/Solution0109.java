package com.song.leetcode;

public class Solution0109 {

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode premid = getMid(head);
        ListNode mid = premid.next;
        premid.next = null;
        TreeNode result = new TreeNode(mid.val);
        result.left = sortedListToBST(head);
        result.right = sortedListToBST(mid.next);
        return result;



    }


    public ListNode getMid(ListNode head){

        ListNode fast = head;
        ListNode slow = head;
        ListNode result = slow;
        while (fast != null && fast.next != null){
            result = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return result;

    }

}
