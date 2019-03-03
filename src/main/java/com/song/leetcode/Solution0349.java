package com.song.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution0349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashset = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for(int e : nums1){
            if(!hashset.contains(e))
                hashset.add(e);
        }

        for(int e:nums2){
            if(hashset.contains(e)){
                result.add(e);
            }
        }

        int[] arr = new int[result.size()];
        int i = 0;
        for (Integer a : result){
            arr[i++] = a;
        }

        return arr;
    }

}
