package com.Facebook2020;

/**
 * Created by Laks on 1/6/16.
 */
public class MergeSort {

    public void mergeSort(int[] a) {
        int[] aux = new int[a.length];
        sort(a,aux,0,a.length-1);
    }

    private void sort(int[] a, int[] aux, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = lo + (hi-lo)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        merge(a,aux,lo,mid,hi);
    }

    private void merge(int[] a, int[] aux, int lo, int mid, int hi) {

        int i = lo, j = mid+1;
            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }

            for (int k = lo; k <= hi; k++) {
                if (i > mid)
                    a[k] = aux[j++];
                else if (j > hi)
                    a[k] = aux[i++];
                else if (aux[i] < aux[j])
                    a[k] = aux[i++];
                else
                    a[k] = aux[j++];
            }
    }
}
