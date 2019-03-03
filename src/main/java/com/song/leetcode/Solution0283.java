package com.song.leetcode;

public class Solution0283 {
    public void moveZeroes(int[] nums) {

        for (int i = nums.length - 1; i >= 0; i--){

            if (nums[i] == 0){

                int j = i;
                while (j < nums.length - 1 && nums[j + 1] != 0){
                    nums[j] = nums[j + 1];
                    nums[++j] = 0;
                }
            }


        }

    }

   /* public void moveZeroes(int[] nums) {
        int[] result=new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            result[i]=nums[i];
        }
        int start=0,end=nums.length-1;
        for(int i=0;i<nums.length;i++) {
            if(result[i]==0)
                nums[end--]=0;
            else
                nums[start++]=result[i];
        }
    }*/
}
