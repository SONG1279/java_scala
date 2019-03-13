package com.song.leetcode;

import java.util.PriorityQueue;

public class Solution0239 {
   /* public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0 || k < 1) {
            return null;
        }
        if (k == 1){
            return nums;
        }

        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[k]);
        }

        result[0] = priorityQueue.peek();
        for (int i = 1; i < nums.length - k + 1; i++) {
            priorityQueue.remove(nums[i - 1]);
            priorityQueue.add(nums[k + i - 1]);
            result[i] = priorityQueue.peek();
        }

        return result;
    }*/
   public int[] maxSlidingWindow(int[] nums, int k) {
       if (nums.length == 0 || k == 0) {
           return new int[] {};
       }

       int[] result = new int[nums.length - k + 1];

       int maxI = getMax(nums, 0, k - 1);
       result[0] = nums[maxI];

       for (int i = 1, j = k - 1 + i; i < result.length; i++, j++) {
           if (maxI >= i && maxI <= j) {
               if (nums[j] > nums[maxI]) {
                   maxI = j;
               }
           } else {
               maxI = getMax(nums, i, j);
           }
           result[i] = nums[maxI];
       }

       return result;
   }

    public static int getMax(int[] arr, int i, int j) {
        int maxIndex = i;

        for (int m = 0, k = i + 1; m < j - i; k++, m++) {
            if (arr[k] > arr[maxIndex]) {
                maxIndex = k;
            }
        }

        return maxIndex;
    }
}
