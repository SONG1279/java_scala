package com.song.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution0260 {

    public int[] singleNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int n : nums){

            if (!set.contains(n)) set.add(n);
            else set.remove(n);

        }
        int[] result = new int[set.size()];
        int a = 0;
        for (int i : set){
            result[a++] = i;
        }
        return result;

    }
/*
* 位计算的方式更快
*    public int[] singleNumber(int[] nums) {
        int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum ^= nums[i];
		}
		int sign = Integer.highestOneBit(sum);
		int r[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & sign) != 0) {
				r[0] ^= nums[i];
			} else {
				r[1] ^= nums[i];
			}
		}
		return r;
    }
*
* */
}
