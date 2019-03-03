package com.song.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);

    }

    public List<List<Integer>> kSum(int[] nums, int start, int k, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (k == 2) {

            int lo = start;
            int hi = nums.length - 1;
            while (lo < hi) {

                if (nums[lo] + nums[hi] == target) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[lo]);
                    tempList.add(nums[hi]);
                    result.add(tempList);
                    lo++;
                    hi--;
                    while (lo < hi  && nums[lo] == nums[lo - 1]) lo++;
                    while (hi > lo && nums[hi] == nums[hi + 1]) hi--;

                } else if (nums[lo] + nums[hi] < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        } else {
            for (int i = start; i < nums.length - (k - 1); i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> lists = kSum(nums, i + 1, k - 1, target - nums[i]);
                for (List<Integer> list : lists) {
                    list.add(0, nums[i]);
                }
                result.addAll(lists);
            }

        }
        return result;

    }


}
