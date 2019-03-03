package com.song.thread.chapter2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 13 on 2017/5/4.
 */
public class HashMapMultiThread {
   // static Map<String, String> map = new HashMap<String, String>();
    static Map<String, String> map = new ConcurrentHashMap<>();

    public static class AddThread implements Runnable {


        int start = 0;

        public AddThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < 100000; i += 2) {
                map.put(Integer.toString(i), Integer.toBinaryString(i));
            }
        }
    }


    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(new HashMapMultiThread.AddThread(0));
        Thread thread2 = new Thread(new HashMapMultiThread.AddThread(1));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(map.size());
    }
}
