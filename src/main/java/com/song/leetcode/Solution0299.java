package com.song.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution0299 {
    public String getHint(String secret, String guess) {
        int[] arr = new int[10];
        int[] brr = new int[10];
        int resultA= 0;
        int resultB= 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) resultA++;
            else {
                arr[secret.charAt(i) - '0'] += 1;
                brr[guess.charAt(i) - '0'] += 1;
            }
        }

        for (int i = 0; i < 10; i++) {
            resultB += Math.min(arr[i], brr[i]);
        }

        return resultA + "A" + resultB + "B";
    }
}
