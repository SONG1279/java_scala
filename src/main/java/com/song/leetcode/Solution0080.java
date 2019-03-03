package com.song.leetcode;

public class Solution0080 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int now = nums[0];
        int index = 1;
        boolean flag = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == now && flag){
                nums[index] = nums[i];
                flag = false;
                index++;
            }
            if (nums[i] > now){
                nums[index] = nums[i];
                now =nums[index];
                flag = true;
                index++;
            }
        }

        return index;

    }

    /*  int i = 0;
		for (int num : nums) {
			if (i < 2 || num > nums[i - 2]) {
				nums[i++] = num;
			}
		}
		return i;*/
}
