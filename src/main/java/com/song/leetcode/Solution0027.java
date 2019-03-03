package com.song.leetcode;

public class Solution0027 {


    public int removeElement(int[] nums, int val) {
        int result = nums.length;
        if (nums.length == 0) return 0;
        if (nums.length == 1 && nums[0] == val) return 0;
        int head = 0;
        int tail = nums.length - 1;
        while (head != tail) {
            if (nums[head] != val) head++;
            else if (nums[tail] == val) {
                tail--;
                result--;
            } else {
                nums[head] = nums[tail];
                tail--;
                result--;
            }
        }
        if (nums[head] == val) result--;
        return result;
    }

}


/* public int removeElement(int[] nums, int val) {
         if (nums.length==0)return 0;
        int first = 0;
        int last = nums.length - 1;
        int result = last + 1;
        while(first <= last){
            if (nums[first] == val){
                if (nums[last] == val){
                    last--;
                }else {
                    int tmp = nums[first];
                    nums[first] = nums[last];
                    nums[last] = tmp;
                    first++;
                    last--;
                    result--;
                }
            }else{
                first++;
            }
        }
        return first;
    }*/