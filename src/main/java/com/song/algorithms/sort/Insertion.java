package com.song.algorithms.sort;

import com.song.algorithms.algs4.StdIn;
import com.song.algorithms.algs4.StdOut;

import java.util.Arrays;

/*插入排序时间取决于初始顺序
*平均比较N^2/4，平均交换N^2/4
*最坏比较N^2/2，最坏交换N^2/2
*最好比较N-1，最好交换N-1
*/

public class Insertion {


    /*//我的方法
    public static void sort(int[] a){
        for (int i = 1; i < a.length; i++) {
            int now = i;
            while (now > 0 && a[now] < a[now - 1]){
                int t = a[now - 1];
                a[now - 1] = a[now];
                a[now] = t;
                now -= 1;
            }
        }
    }*/

    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]) ; j--) {
                exce(a, j, j - 1);
            }
        }
    }

    public static void sort(Comparable[] a, int lo, int hi){
        int N = hi - lo + 1;
        for (int i = lo + 1; i < hi + 1; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]) ; j--) {
                exce(a, j, j - 1);
            }
        }
    }



    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        //int[] a = new int[]{2,3,1,54,1,34,21,7,5,34,23,12,1,5,12,59};
        sort(a);
        //System.out.println(Arrays.toString(a));
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
