package com.song.leetcode;

public class Solution0013 {

    public int romanToInt(String s) {
        boolean subC = false,subX = false, subI = false;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'M': if (subC) result -= 200; result += 1000; subC=false;break;
                case 'D':if (subC) result -= 200; result += 500; subC=false;break;
                case 'C':if (subX) result -= 20; result+=100; subC = true; subX = false;break;
                case 'L':if (subX) result -=20;result += 50;subX = false;break;
                case 'X':if (subI) result -= 2; result += 10;subX = true;subI = false;break;
                case 'V': if (subI) result -= 2; result += 5;subI = false;break;
                case 'I': result += 1; subI = true;
            }


        }
        return result;
    }

}
