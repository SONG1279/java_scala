package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution0052 {

    public int result = 0;

    public int totalNQueens(int n) {
        if (n == 1) {
            return 1;
        }
        if (n <= 3) return 0;
        StringBuilder sb = new StringBuilder("");
        List<String> list = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        for (int i = 0; i < n; i++) {
            list.add(sb.replace(i, i + 1, "Q").toString());
            sb.replace(i, i + 1, ".");
            index.add(i);
        }

        backTracking(tmp,0, index, list);
        return result;
    }

    public void backTracking(int[] now, int nowIndex, List<Integer> index, List<String> list) {

        if (nowIndex == now.length) {
            result++;
            return;
        }

        for (int i = 0; i < index.size(); i++) {
            int a = index.remove(i);
            now[nowIndex] = a;
            if (!verify(now, nowIndex)) {
                index.add(i,a);
                continue;
            }
            backTracking(now, nowIndex + 1, index, list);
            index.add(i,a);

        }
    }

    public boolean verify(int[] now, int nowIndex) {
        if (nowIndex == 0) return true;
        for (int i = 0; i < nowIndex; i++) {
            if (Math.abs(now[i] - now[nowIndex]) == nowIndex - i) return false;
        }
        return true;
    }


}
