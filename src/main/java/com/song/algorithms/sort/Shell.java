package com.song.algorithms.sort;

import com.song.algorithms.algs4.StdIn;
import com.song.algorithms.algs4.StdOut;


/*最坏比较次数N^(3/2)*/
public class Shell {

    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h < N / 3){
            h = 3 * h + 1;
        }
        while (h >= 1){
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]) ; j -= h) {
                    exce(a, j, j - h);
                }
            }
            h = h / 3;
        }
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
