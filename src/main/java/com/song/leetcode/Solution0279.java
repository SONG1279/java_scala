package com.song.leetcode;

public class Solution0279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j* j >= 0){
                min = Math.min(min, dp[i - j * j] + 1);
                j++;
            }



        }
        return dp[n];
    }

/*
*  public int numSquares(int n) {
        //四平方和定理:即一个数肯定可以由4或者4以内的个数的数的平方累加得到，所以这里的答案只能为1、2、3、4
        while(n%4==0){//如果这个数可以整除4，那么除以4，不影响结果
            n /= 4;
        }
        if(n%8==7){//如果这个数对8取余得到7，那么肯定需要四个数的平方和
            return 4;
        }
        for(int i=0;i*i<=n;i++){//看是否可以拆分成两个数(有可能一个数为0,但是因为n是正整数,所以不可能都是0),如果拆完有一个为0，则返回1，否则返回2
            int j=(int)Math.sqrt(n-i*i);
            if(i*i+j*j==n){
                if(i==0 || j==0){
                    return 1;
                }
                return 2;
            }
        }
        //最后，如果不是4、1、2，那么只能为3
        return 3;
    }
* */
}
