package com.song.jvm;

public interface Test {

    public int a = 1;

    default void say(){
        System.out.println("protect");
    }

    abstract void say2();


}
