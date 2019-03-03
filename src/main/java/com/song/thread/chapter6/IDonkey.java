package com.song.thread.chapter6;

public interface IDonkey {
    void eat();
    default void run(){
        System.out.println("donkey run");
    }
}
