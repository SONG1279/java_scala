package com.song.leetcode;

public class Solution0705 {

}

class MyHashSet {


    boolean[] arr;
    /** Initialize your data structure here. */
    public MyHashSet() {
        arr = new boolean[1000000];
    }

    public void add(int key) {
        arr[key] = true;
    }

    public void remove(int key) {
        arr[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return arr[key];
    }
}
