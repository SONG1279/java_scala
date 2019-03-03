package com.song.leetcode;

public class Solution0043 {
/* 我的方法，耗时很久
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String result = "0";
        int j = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            String tmpNum1 = new String(num1);
            for (int k = 0; k < j; k++) {
                tmpNum1 += "0";
            }
            String tmp = mulOne(tmpNum1, num2.charAt(i));
            result = plus(result, tmp);
        }
        return result;

    }

    public String plus(String num1, String num2){
        int up = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder("");
        while (i >= 0 || j >= 0){
            int a = 0, b = 0;
            if (i >= 0) a = num1.charAt(i--) - '0';
            if (j >= 0) b = num2.charAt(j--) - '0';
            int tmp = a + b + up;
            up = tmp / 10;
            sb.insert(0, tmp % 10);
        }
        if (up != 0) sb.insert(0,up);
        return sb.toString();

    }

    public String mulOne(String num, char c){

        int up = 0;
        int cc = c - '0';
        StringBuilder sb = new StringBuilder("");
        for (int i = num.length() - 1; i >= 0 ; i--) {
            int tmp = num.charAt(i) - '0';
            int tmp2 = tmp * cc + up;
            up = tmp2 / 10 ;
            sb.insert(0, tmp2 % 10);
        }

        if (up != 0) sb.insert(0, up);
        return sb.toString();
    }*/


//一个快速的方法
    public String multiply(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        if(n1 < 0 || n2 < 0)
            return "";
        int[] mul = new int[n1+n2+2];

        for(int i = n1; i >= 0; i--){
            for(int j = n2; j >= 0; j--){
                int bitmul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                bitmul += mul[i+j+1];
                mul[i+j] += bitmul / 10;
                mul[i+j+1] = bitmul % 10;
            }
        }
        StringBuilder s = new StringBuilder();
        int i = 0;
        while(i < mul.length - 1 && mul[i] == 0)
            i++;
        for(; i < mul.length; i++)
            s.append(mul[i]);
        return s.toString();
    }
}
