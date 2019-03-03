package com.song.thread.chapter6;

import java.util.stream.IntStream;

public class PrimeUtil {
    public static boolean isPrime(int number){
        int tmp = number;
        if (tmp < 2) return false;
        for (int i = 2; i <= Math.sqrt(tmp); i++) {
            if (tmp % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        System.out.println(IntStream.range(1, 1000000).filter(PrimeUtil::isPrime).count());
        Long end = System.currentTimeMillis();
        System.out.println("time is " + (end - start));
        start = System.currentTimeMillis();
        System.out.println(IntStream.range(1, 1000000).parallel().filter(PrimeUtil::isPrime).count());
        end = System.currentTimeMillis();
        System.out.println("time is " + (end - start));

    }
}
