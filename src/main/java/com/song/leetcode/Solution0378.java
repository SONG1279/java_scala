package com.song.leetcode;

import java.util.PriorityQueue;

public class Solution0378 {
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2 - o1);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (queue.size() < k){
                    queue.add(matrix[i][j]);
                } else if (matrix[i][j] < queue.peek()){
                    queue.remove();
                    queue.add(matrix[i][j]);
                } else if (matrix[i][j] >= queue.peek()){

                    break;

                }
            }

        }
        return queue.remove();


    }
}
