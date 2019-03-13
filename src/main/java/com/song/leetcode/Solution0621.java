package com.song.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution0621 {
    public int leastInterval(char[] tasks, int n) {

        int[] arr = new int[26];
        for (char c : tasks){
            arr[c - 'A'] += 1;
        }
        Arrays.sort(arr);
        int max = 0;
        for (int i = 25; i >=0 ; i++) {
            if (arr[i] < arr[25]){
                break;
            }
            max++;
        }

        return Math.max((arr[25] - 1)*(n + 1) + max, tasks.length);


    }
}
