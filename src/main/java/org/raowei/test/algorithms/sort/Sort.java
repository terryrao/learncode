package org.raowei.test.algorithms.sort;

import com.sun.scenario.effect.Merge;
import org.apache.commons.lang3.time.StopWatch;
import org.raowei.test.algorithms.util.StdIn;

import java.util.Arrays;

/**
 * Created by terryrao on 2016/4/2.
 */
public class Sort {
    private static Comparable[] aux;

    public static void selectSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }

    }

    public static void insertionSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void shellSort(Comparable[] a) {
        int h = 1; //分组大小
        int N = a.length;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            for (int i = h; i < N; i++) {
                for (int j = 0; j + h < N; j = j + h) {
                    if (less(a[j + h], a[j])) {
                        exch(a, j, j + h);
                    }
                }
            }
            h = h / 3;
        }

    }

    /**
     * 本地并归排序法
     */
    public static void localMerge(Comparable a[], int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (k > mid) a[k] = aux[j++];
            else if (k > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];

        }

    }

    public static void mmergeSort(Comparable a[]) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }


    private static void sort(Comparable a[], int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo +(hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        localMerge(a, lo, mid, hi);
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return Boolean.FALSE;
        }
        return true;
    }

    public static void main(String[] args) {
//        String[] a = StdIn.readAllStrings();
        String[] b = new String[] {"S","O","R","T","E","X","M","A","P","L","E"};
        long start = System.currentTimeMillis();
//        Sort.selectSort(a);
//        Sort.insertionSort(a);

//        Sort.shellSort(a);
        Sort.mmergeSort(b);
        long end = System.currentTimeMillis();

        Sort.show(b);

        System.out.println("耗时:" + (end - start));
    }

}
