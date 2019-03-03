package com.song.leetcode;

import java.util.*;

public class Solution0752 {
    public int openLock(String[] deadends, String target) {

        Set<String> list = new HashSet<>(Arrays.asList(deadends));
        Set<String> set = new HashSet<>();

        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();

        q1.offer("0000");
        int step = 0;

        if (list.contains("0000") || list.contains(target)) return -1;
        while (!q1.isEmpty()) {

            String cur = q1.poll();
            if (target.equals(cur)) return step;
            List<String> next = getNext(cur);

            for (String s : next) {
                if (!list.contains(s) && !set.contains(s)) {

                    q2.offer(s);
                    set.add(s);
                }

            }

            if (q1.isEmpty()) {

                step++;
                q1 = q2;
                q2 = new LinkedList<String>();

            }

        }
        return -1;

    }

    public List<String> getNext(String cur) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            StringBuilder curSb = new StringBuilder(cur);
            curSb.setCharAt(i, cur.charAt(i) == '0' ? '9' : (char) (cur.charAt(i) - 1));
            list.add(curSb.toString());
            curSb.setCharAt(i, (char) cur.charAt(i) == '9' ? '0' : (char) (cur.charAt(i) + 1));
            list.add(curSb.toString());

        }
        return list;
    }
}
