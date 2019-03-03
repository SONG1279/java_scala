package com.song.leetcode;

import java.util.*;

public class Solution0187 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();

        if (s.length() < 10) {
            return result;
        }
        if (s.length() == 10){
            result.add(s);
            return result;
        }

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        for (int i = 0; i < s.length() - 10; i++) {
            if (set1.add(s.substring(i, i + 10))) {
                set2.add(s.substring(i, i + 10));
            }
        }
        for (String s1 : set2) {
            result.add(s1);
        }

return result;
    }

}
