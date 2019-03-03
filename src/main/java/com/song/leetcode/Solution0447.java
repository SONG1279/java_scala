package com.song.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution0447 {
    public int numberOfBoomerangs(int[][] points) {

        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                Double tmp = Math.pow(points[i][0] - points[j][0], 2) +
                        Math.pow(points[i][1] - points[j][1], 2);
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }

            for (Map.Entry<Double, Integer> entry : map.entrySet()){

                result += entry.getValue() * (entry.getValue() - 1);

            }

        }
        return result;

    }
}
