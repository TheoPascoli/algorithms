package com.pascoli.algorithms.sorting;

import java.time.Duration;
import java.time.Instant;

public class SortCompare {

    public static double time(String alg, Double[] a) {
        Instant start = Instant.now();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        Instant end = Instant.now();
        return Duration.between(start, end).toMillis();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for(int i = 0; i < T; i++) {
            a[i] = StdRandom.uniform();
        }
        total += time(alg, a);
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        System.out.println(String.format("For %d random Doubles\n %s is", N, alg1));
        System.out.println(String.format(" %1.f times faster than %s", t2/t1, alg2));
    }
}
