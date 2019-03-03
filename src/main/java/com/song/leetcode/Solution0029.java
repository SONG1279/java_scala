package com.song.leetcode;


//这题不太好

//TODO
public class Solution0029 {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        boolean absFlag1 = true;
        boolean absFlag2 = true;
        if (dividend < 0) {
            absFlag1 = false;
            dividend = -dividend;
        }
        if (divisor < 0) {
            divisor = -divisor;
            absFlag2 = false;
        }
        int result = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            result++;


        }

        if ( !absFlag1 ^ absFlag2) return result;
        return -result;


    }

}


/* public int divide(int dividend, int divisor) {
        if (divisor ==0)return -1;
        if (dividend == 2147483647 || dividend == -2147483647){
            return dividend;
        }
        int result = 0;
        int dividend1 = dividend;
        int divisor1 = divisor;
        int tmp = 0;
        if (dividend < 0){
            dividend1 = -dividend;
        }
        if (dividend1 == dividend && dividend < 0){
            dividend1 = -(dividend + 1);
            tmp = 1;
        }
        if (divisor < 0){
            divisor1 = -divisor;
        }

        int sum = 0;
        while (sum < dividend1){
            sum += divisor1;
            result += 1;
        }
        if (sum > dividend1){
            result += tmp;
            result--;
        }
        if ((dividend < 0&&divisor > 0)||(dividend > 0&&divisor < 0)){
            result = -result;
        }


        return result;



    }*/