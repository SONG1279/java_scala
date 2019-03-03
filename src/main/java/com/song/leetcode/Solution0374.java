package com.song.leetcode;

public class Solution0374 {
    public int guessNumber(int n) {

        int low = 1;
        while (low <= n){

            int mid = low + (n - low) / 2;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) == -1) n = mid - 1;
            else if (guess(mid) == 1) low = mid + 1;
        }
        return -1;

    }

    public int guess(int num){
        return 0;
    }
}
