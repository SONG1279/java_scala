package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution0228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int k = i + 1;
            while (k < nums.length && nums[k] == nums[k - 1] + 1) k++;
            if (k == i + 1) {
                result.add(String.valueOf(nums[i]));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                sb.append("->");
                sb.append(nums[k - 1]);
                result.add(sb.toString());
            }
            i = k;
        }
        return result;

    }


}
