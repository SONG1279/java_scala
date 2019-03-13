package com.song.leetcode;

import java.util.Stack;

public class Solution0430 {

    public Node flatten(Node head) {
        Node pre = new Node(0, null, head, null);
        Stack<Node> stack = new Stack<>();

        while (head != null) {

            if (head.child != null) {
                if (head.next != null) {
                    stack.push(head.next);

                }
                head.next = head.child;
                head.next.prev = head;

            } else if (head.next == null && !stack.isEmpty()) {

                head.next = stack.pop();
                head.next.prev = head;
            }

            head = head.next;


        }
        return pre.next;

    }


    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    ;


}


