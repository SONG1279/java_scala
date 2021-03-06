package com.song.algorithms.sort;

import com.song.algorithms.algs4.StdOut;
import com.song.algorithms.algs4.StdRandom;
import com.song.algorithms.foundation.Stopwatch;

public class SortCompare {

    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion"))
            Insertion.sort(a);
        if(alg.equals("Selection"))
            Selection.sort(a);
        if(alg.equals("Shell"))
            Shell.sort(a);
        if(alg.equals("Merge"))
            Merge.sort(a);
        if(alg.equals("Quick"))
            Quick.sort(a);
//        if(alg.equals("Heap"))
//            Heap.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T){
        double total = 0.1;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }


    public static void main(String[] args) {
        String alg1 = "Quick";
        String alg2 = "Merge";
        int N = 10000;
        int T = 100;
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);

        StdOut.printf("For %d random Doubles\n    %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
        StdOut.printf("%s use time %.2f", alg1, t1);
        StdOut.println();
        StdOut.printf("%s use time %.2f", alg2, t2);
    }

}
