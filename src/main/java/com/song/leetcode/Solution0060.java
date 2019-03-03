package com.song.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution0060 {
    public String getPermutation(int n, int k) {
        List<Character> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add((char) ('0' + i));
        }
        StringBuilder sb = new StringBuilder();
        return getIt(sb, n, list, k);
    }

    public String getIt(StringBuilder sb, int nowIndex,List<Character> list,int k){
        if (nowIndex == 0) return sb.toString();

        for (int i = 0; i < list.size(); i++) {

            if (k > n_1(list.size() - 1)) {
                k -= n_1(list.size() - 1);
                continue;
            }

            char a = list.remove(i);
            sb.append(a);
            return    getIt(sb, nowIndex - 1,list,k);


        }
        return null;
        }


    public int n_1(int n){

        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;


    }


}
