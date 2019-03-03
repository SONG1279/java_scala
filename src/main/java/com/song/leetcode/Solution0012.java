package com.song.leetcode;
/*
* 我的方法看起来长
* 但也还行
* 对方方法有创造力
* */
public class Solution0012 {

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        while (num != 0) {

            if (num >= 1000) {
                num -= 1000;
                sb.append("M");
            } else if (num >= 900) {
                num -= 900;
                sb.append("CM");
            } else if (num >= 500) {
                num -= 500;
                sb.append("D");
            } else if (num >= 400) {
                num -= 400;
                sb.append("CD");
            } else if (num >= 100) {
                num -= 100;
                sb.append("C");
             } else if (num >= 90){
                num -= 90;
                sb.append("XC");
            }
            else if (num >= 50) {
                num -= 50;
                sb.append("L");
            } else if (num >= 40) {
                num -= 40;
                sb.append("XL");
            } else if (num >= 10) {
                num -= 10;
                sb.append("X");
            } else if (num >= 9) {
                num -= 9;
                sb.append("IX");
            } else if (num >= 5) {
                num -= 5;
                sb.append("V");
            } else if (num >= 4) {
                num -= 4;
                sb.append("IV");
            } else if (num >= 1) {
                num -= 1;
                sb.append("I");
            }


        }

        return sb.toString();
    }

/*public String intToRoman(int num) {

        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return  M[num / 1000] + C[num % 1000 / 100] + X[num % 100 / 10] + I[num % 10];
    }*/
}
