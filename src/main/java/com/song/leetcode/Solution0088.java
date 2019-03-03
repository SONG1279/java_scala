package com.song.leetcode;

/**
 * @author hadoop
 */
public class Solution0088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int tmp = m + n - 1;

        while (tmp >= 0) {

            if (m == 0 && n > 0){
                nums1[tmp--] = nums2[n - 1];
                n--;
            } else if (n == 0 && m > 0){
                nums1[tmp--] = nums1[m - 1];
                m--;
            }else if (nums1[m - 1] >= nums2[n - 1]){
                nums1[tmp--] = nums1[m - 1];
                m--;
            }else  {
                nums1[tmp--] = nums2[n - 1];
                n--;
            }
        }
    }
}
