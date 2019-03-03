package com.song.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution0001 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target -nums[i]), i};
            }
            map.put(nums[i], i);
            
        }
        return null;

    }

   /*
    第一次
    public int[] twoSum(int[] nums, int target) {
        int[] arr={0,0};
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j])==target){
                    arr[0]=i;
                    arr[1]=j;
                    return arr;
                }
            }
        }
        return null;
    }*/
}
