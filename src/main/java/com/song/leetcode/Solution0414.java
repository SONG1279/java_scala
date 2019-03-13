package com.song.leetcode;

import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Solution0414 {
    public int thirdMax(int[] nums) {

        if(nums == null || nums.length == 0) {
            return -1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(3);
        queue.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (queue.size() < 3 && !queue.contains(nums[i])) {
                queue.add(nums[i]);
            } else {

                if (queue.peek() < nums[i] && !queue.contains(nums[i])){

                    queue.poll();
                    queue.add(nums[i]);

                }


            }


        }
        if (queue.size()== 2){
            queue.poll();
        }

        return queue.peek();

    }
}
