package com.song.leetcode;

public class Solution0278 {
    public int firstBadVersion(int n) {

        int lo = 1;
        int hi = n;

        while (lo < hi){

            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;


    }

    boolean isBadVersion(int n){
        return true;
    }
}
