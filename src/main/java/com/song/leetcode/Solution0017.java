package com.song.leetcode;

import scala.Char;

import java.util.*;

public class Solution0017 {

    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() < 0) return result;
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3',Arrays.asList('d','e','f'));
        map.put('4',Arrays.asList('g','h','i'));
        map.put('5',Arrays.asList('j','k','l'));
        map.put('6',Arrays.asList('m','n','o'));
        map.put('7',Arrays.asList('p','q','r','s'));
        map.put('8',Arrays.asList('t','u','v'));
        map.put('9',Arrays.asList('w','x','y','z'));
        getit("",digits,0,map);

        return result;
    }

    public void getit(String str, String digits, int i, Map<Character, List<Character>> map){
        if (i == digits.length()) {
            result.add(str);
            return;
        }
        List<Character> list = map.get(digits.charAt(i));
        for (Character c : list){
            String nstr = str + c;
            getit(nstr, digits, i+1, map);
        }
    }

}

/* //第一次写的
*  String[][] matrix =
            {{"a", "b", "c"},
                    {"d", "e", "f"},
                    {"g", "h", "i"},
                    {"j", "k", "l"},
                    {"m", "n", "o"},
                    {"p", "q", "r", "s"},
                    {"t", "u", "v"},
                    {"w", "x", "y", "z"}};
    List<String> result = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() ==0)return result;

        char[] arr = digits.toCharArray();
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i] - '0';
        }
        getIt("", tmp, 0);
        return result;


    }

    public void getIt(String arr, int[] num, int i){
        int temp = num[i];
        for (int j = 0; j < matrix[temp - 2].length; j++){
            String tmp =  arr + matrix[temp - 2][j];
            if (i == num.length - 1){
                result.add(tmp);
                continue;
            }
            getIt(tmp, num, i + 1);
        }
    }*/
