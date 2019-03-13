package com.song.leetcode;

import java.util.PriorityQueue;

public class Solution0295 {
}

class MedianFinder {

    int size;
    PriorityQueue<Integer> minPQ;
    PriorityQueue<Integer> maxPQ;
    /** initialize your data structure here. */
    public MedianFinder() {
        size = 0;
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>((a, b) -> (b - a));
    }

    public void addNum(int num) {
        if (minPQ.size() < ++size/ 2){
            if (num > maxPQ.peek()){
                minPQ.add(num);
            } else {
                minPQ.add(maxPQ.remove());
                maxPQ.add(num);
            }


        } else {

            if (maxPQ.isEmpty() || num <= minPQ.peek()){
                maxPQ.add(num);
            } else {

                maxPQ.add(minPQ.remove());
                maxPQ.add(num);
            }

        }
    }

    public double findMedian() {

        if (maxPQ.isEmpty() && minPQ.isEmpty()){

            return -1;

        }

        if (maxPQ.size() >minPQ.size()){
            return (double) maxPQ.peek();
        }

        return ((double)minPQ.peek() + (double)maxPQ.peek()) / 2;

    }
}
