package com.song.leetcode;

public class Solution0035 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;

        int lo = 0, hi = nums.length - 1;

        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if (hi - lo == 1 && target > nums[lo] && target < nums[hi]) return hi;
            if (hi - lo == 1 && target < nums[lo]) return lo;
            if (lo == hi && target > nums[lo]) return lo + 1;
            if (lo == hi && target < nums[lo]) return lo;
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) hi = mid - 1;
            else if (target > nums[mid]) lo = mid + 1;
        }

return -1;
    }
}
