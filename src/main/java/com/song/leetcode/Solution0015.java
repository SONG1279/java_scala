package com.song.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*
* 我太🐮🍺了
* */

public class Solution0015 {

    //这是我自己写的，哈哈哈哈哈
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {

            int lo = i + 1;
            int hi = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1])continue;

            while (lo < hi) {
                if (nums[i] + nums[lo] + nums[hi] > 0) hi--;
                else if (nums[i] + nums[lo] + nums[hi] < 0) lo++;
                else {

                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    hi--;
                    lo++;
                }
                while (hi < nums.length - 1 && hi > lo&& nums[hi] == nums[hi+1])hi--;
                while (lo > i + 1 && lo < hi && nums[lo] == nums[lo - 1])lo++;
            }


        }
        return result;


    }

































    /*
    *  public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return kSum(nums, 0, 3, 0);

    }

    public List<List<Integer>> kSum(int[] nums, int start, int k, int target){

        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (k == 2) {
            int left = start;
            int right = len - 1;
            while (left < right){
                if (nums[left] + nums[right] == target){
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[left]);
                    path.add(nums[right]);
                    result.add(path);
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[left] == nums[right - 1]) right--;
                    left++;
                    right--;
                }else if (nums[left] + nums[right] < target) {
                    left++;
                }else {
                    right--;
                }

            }
        } else {
            for (int i = start; i < len - (k - 1); i++){
                if (i > start && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> tmp = kSum(nums, i + 1, k - 1, target - nums[i]);
                for (List<Integer> list : tmp){
                    list.add(0, nums[i]);
                }

                result.addAll(tmp);
            }
        }
        return result;
    }*/

}
