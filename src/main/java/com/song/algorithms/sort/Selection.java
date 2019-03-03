package com.song.algorithms.sort;

import com.song.algorithms.algs4.In;
import com.song.algorithms.algs4.StdIn;
import com.song.algorithms.algs4.StdOut;

import java.util.Arrays;

/*选择排序
* 运行时间与输入无关，数据移动最少
* N^2/2次比较，N次交换
*/
public class Selection {

    /*
    //我的方法
    public static void sort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int mina = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    mina = j;
                }
            }
            int tmp = a[i];
            a[i] = a[mina];
            a[mina] = tmp;
        }
    }*/

    public static void sort(Comparable[] a){

        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j =  i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exce(a, i, min);
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
