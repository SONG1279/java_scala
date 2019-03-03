package com.song.algorithms.sort;

import com.song.algorithms.algs4.StdIn;
import com.song.algorithms.algs4.StdOut;
import com.song.algorithms.algs4.StdRandom;

public class Quick {

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);

    }

    public static void sort(Comparable[] a, int lo, int hi){

        if (hi <= lo + 10) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);

    }

    public static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true){
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >=j) break;
            exce(a, i, j);
        }
        exce(a, lo, j);
        return j;
    }


    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }



    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void exce(Comparable[] a, int i, int j){
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }



}
