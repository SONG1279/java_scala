package com.song.leetcode;

public class Solution0138 {
    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) return null;
        RandomListNode tmp = head;
        while (tmp != null) {

            RandomListNode tmp1 = new RandomListNode(tmp.label);
            tmp1.next = tmp.next;
            tmp.next = tmp1;
            tmp = tmp.next.next;
        }
        tmp = head;
        while (tmp != null){
            if(tmp.random != null) tmp.next.random = tmp.random.next;
            tmp = tmp.next.next;
        }

        RandomListNode result = new RandomListNode(-1);
        RandomListNode result1 = result;
        RandomListNode beforehead = new RandomListNode(-1);
        tmp = head;
        while (tmp != null){

            beforehead.next = tmp;
            beforehead = beforehead.next;
            tmp = tmp.next;
            beforehead.next = null;
            result.next = tmp;
            result = result.next;
            tmp = tmp.next;
            result.next = null;


        }

        return result1.next;

    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}