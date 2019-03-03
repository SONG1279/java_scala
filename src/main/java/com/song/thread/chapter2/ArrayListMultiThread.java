package com.song.thread.chapter2;

import java.util.ArrayList;

/**
 * Created by 13 on 2017/5/4.
 */
public class ArrayListMultiThread {

    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                arrayList.add(i);
            }
        }
    }


    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(new AddThread());
        Thread thread2 = new Thread(new AddThread());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(arrayList.size());
    }

}
