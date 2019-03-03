package com.song.leetcode;

public class Solution0706 {
}
class MyHashMap {

    int[] arr;

    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new int[1000000];
        for (int a  = 0; a < arr.length; a++) {
            arr[a] = -1;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        arr[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
         return arr[key];

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        arr[key] = -1;
    }
}
