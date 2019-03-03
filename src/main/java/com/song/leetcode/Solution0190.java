package com.song.leetcode;

public class Solution0190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int right = 0x00000001;
        int left = 0x80000000;
        for (int i = 0; i < 16; i++) {

            int a = n & right;
            int b = n & left;
            if ((a == 0 && b == 0) || (a != 0 && b != 0)) {

            } else {
                if (a == 0) {
                    n = n & ~left;
                    n = n ^ right;
                } else {
                    n = n ^ left;
                    n = n & ~right;
                }
            }
            System.out.println(Integer.toBinaryString(n));
            right = right << 1;
            left = left >>> 1;

        }
        return n;
    }




    /*  // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int re = 0;
        for(int i = 0; i < 32; i++){
            re <<= 1;
            re += n & 1;
            n >>= 1;
        }
        return re;
    }*/

    /*
    *
    * 如果该函数需要被调用很多次，可以将 int 拆成 4 个 byte，然后缓存 byte 对应的比特位翻转，最后再拼接起来。

private static Map<Byte, Integer> cache = new HashMap<>();

public int reverseBits(int n) {
    int ret = 0;
    for (int i = 0; i < 4; i++) {
        ret <<= 8;
        ret |= reverseByte((byte) (n & 0b11111111));
        n >>= 8;
    }
    return ret;
}

private int reverseByte(byte b) {
    if (cache.containsKey(b)) return cache.get(b);
    int ret = 0;
    byte t = b;
    for (int i = 0; i < 8; i++) {
        ret <<= 1;
        ret |= t & 1;
        t >>= 1;
    }
    cache.put(b, ret);
    return ret;
}

    * */
}
