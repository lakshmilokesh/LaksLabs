package com.sorting;

import com.sorting.QuickSort;

/**
 * Created by Laks on 1/6/16.
 *
 * Goal : Find the kth largest element
 */
public class QuickSelection {

    public int select(int a[], int k) {
        //StdRandom.shuffle(a);
        int lo = 0, hi = a.length;
        while (lo <= hi) {
            int j = QuickSort.partition(a,lo,hi);
            if (k > j) {
                lo = j+1;
            }
            else if (k < j) {
                hi = j-1;
            }
            else
                return a[k];
        }
        return a[k];
    }
}
