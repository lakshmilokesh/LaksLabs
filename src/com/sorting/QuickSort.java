package com.sorting;

/**
 * Created by Laks on 1/6/16.
 */
public class QuickSort {

    public void quickSort(int []a) {
        //stdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    private void sort(int[] a, int lo, int hi) {

        if (hi <= lo)
            return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);

        }

    public static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        while(true) {
            while (a[lo] > a[++i])
                if (i == hi)
                    break;
            while (a[lo] < a[--j])
                if (j == lo)
                    break;

            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a,lo,j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}