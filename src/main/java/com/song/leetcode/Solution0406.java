package com.song.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0406 {
    public int[][] reconstructQueue(int[][] people) {

        if (people == null || people.length == 0 || people[0].length == 0) return  null;

        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));

        List<int[]> list = new ArrayList<>();

        for (int[] p : people){

            list.add(p[1], p);

        }

        return list.toArray(new int[list.size()][]);

    }
}
