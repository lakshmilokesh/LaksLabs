package com.sorting;

/**
 * Created by Laks on 1/8/16.
 *
 * Dijkstra's 3 way partitioning algorithm
 *
 * Partition item a[lo] ;let it be v
 * Scan i from left to right
 * a[i] < v ; exchange a[lt] with a[i]
 *            increment lt and i
 *
 * a[i] > v ; exchange a[gt] and a[i]
 *            decrement gt
 *
 * a[i] == [v] ; increment i
 *
 */
public class ThreeWayQuickSort {

    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int lt = lo, i = lo;
        int gt = hi;
        int v = a[lo];
        while (i <= gt) {
            if (a[i] < v) {
                swap(a, lt, i);
                lt++;
                i++;
            }
            else if (a[i] > v) {
                swap(a,gt,i);
                gt--;
            }
            else {
                i++;
            }
        }

        sort(a,lo,lt - 1);
        sort(a,gt+1,hi);
    }


    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}