package com.binarytree;

import com.sorting.InsertionSort;

/**
 * Created by Laks on 8/4/17.
 */
public class UnorderedMaxPriorityQueue {

    /*
     * unordered array implementation
     */
    private Integer[] maxpq;
    private int N;

    public UnorderedMaxPriorityQueue(int capacity) {
        maxpq = new Integer[capacity];
    }

    public void insert(int x) {
        maxpq[N++] = x;
    }

    public boolean isEmpty() {
        return N==0;
    }

    public int deleteMax() {
        int max = 0;
        for(int i = 1; i <N ; i++) {
            if (maxpq[max] < maxpq[i]) {
                max = i;
            }
        }
        InsertionSort.exch(maxpq,max,N-1);
        return maxpq[--N];
    }

}
