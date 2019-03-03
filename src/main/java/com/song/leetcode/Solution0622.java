package com.song.leetcode;

import java.util.List;

public class Solution0622 {
}

class MyCircularQueue {


    int[] queue;
    int head;
    int tail;
    boolean empty;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
        empty = true;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        queue[tail] = value;
        empty = false;
        if (tail == queue.length - 1){
            tail = 0;
        } else {
            tail++;
        }

        return true;


    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (empty) return false;
        if (head == queue.length - 1){
            head = 0;
        } else {
            head++;
        }
        if (head == tail) empty = true;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (empty) return -1;
        return queue[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (empty) return -1;
        if (tail == 0) return queue[queue.length - 1];
        return queue[tail - 1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {

        return empty;

    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if (head == tail && !empty) return true;
        return false;
    }
}