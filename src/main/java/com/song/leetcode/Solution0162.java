package com.song.leetcode;

public class Solution0162 {

    public int findPeakElement(int[] nums) {
        if (nums.length <= 1) return 0;
        if (nums[0] > nums[1])return 0;
        if (nums[nums.length - 1] > nums[nums.length -2]) return nums.length - 1;
        return findPeakElement(nums, 0, nums.length - 1);
    }

    public int findPeakElement(int[] num, int lo, int hi){

        if (lo == hi) return 0;
        int mid = lo + (hi - lo) / 2;
        if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) return mid;

        int a= findPeakElement(num, lo, mid);
        if (a != 0) return a;
        a = findPeakElement(num, mid + 1, hi);
        if (a != 0) return a;
        return 0;
    }

}
