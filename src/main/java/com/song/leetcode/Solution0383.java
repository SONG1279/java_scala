package com.song.leetcode;

public class Solution0383 {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] mag = new int[128];
        for (char c : magazine.toCharArray()){

            mag[c] += 1;

        }
        for (char c : ransomNote.toCharArray()){
            mag[c] -= 1;
            if (mag[c] < 0) return false;
        }
        return true;

    }


}
