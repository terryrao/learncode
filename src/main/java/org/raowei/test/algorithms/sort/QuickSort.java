package org.raowei.test.algorithms.sort;

import org.raowei.test.algorithms.util.SortUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 快速排序法
 */
public class QuickSort {


    /**
     * 切分
     *
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1; //扫描指针
        Comparable v = a[lo];
        while (true) {
            while (SortUtils.less( a[++i],v)) {
                if (i >= hi) break;
            }
            while (SortUtils.less(v,a[--j])) {
                if (j <= lo) break;
            }

            if (i >= j) {
                break;
            }
            SortUtils.exch(a,i,j);

        }

        SortUtils.exch(a,lo,j);
        return j;
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int v = partition(a, lo, hi);
        sort(a, lo, v - 1);
        sort(a, v+1, hi-1);
    }

    public static void quickSort(Comparable[] a ) {
        sort(a,0,a.length -1);
    }

    public static void main(String[] args) {
        String[] a  =new String[] {"K", "R","A","T","E","L","E","P","U","I","M","Q","C","X","O","S"};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
