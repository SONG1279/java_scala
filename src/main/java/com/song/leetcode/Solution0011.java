package com.song.leetcode;

public class Solution0011 {

    public int maxArea(int[] height) {

        int lo = 0;
        int hi = height.length - 1;
        int result = 0;
        while (hi > lo){
            result = Math.max(result, Math.min(height[lo],height[hi]) * (hi - lo));
            if (height[lo] > height[hi]) hi--;
            else lo++;
        }
        return result;

    }

}
