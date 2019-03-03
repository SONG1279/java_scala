package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution0658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int L = 0, R = arr.length - k;//首位指针范围以k为单位
        while (L < R) {
            int mid = L + (R - L) / 2;
            //若前者大，则x应在mid右侧
            if (Math.abs(arr[mid] - x) > Math.abs(arr[mid + k] - x))
                L = mid + 1;
            else
                R = mid;
        }
        for (int i = L; i < L + k; i++)
            list.add(arr[i]);
        return list;
    }
}
