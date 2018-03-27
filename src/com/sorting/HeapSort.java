package com.sorting;

/**
 * Created by Laks on 1/13/16.
 *
 * STEP 1 : Build heap using bottom up
 * STEP 2 : Delete Max. Leave in the array instead of deleting
 *
 * In place sorting algorithm with n log n worst case.
 *
 *
 *            1
 *          /  \
 *         2    3
 *        / \  / \
 *       4  5 6  7
 *
 *   here n/2 = 3. So it will start with node 3, then 2 then 1 . 4,5,6,7 are heap of size 1
 *
 */
public class HeapSort {

    public static void sort(int[]  pq) {
        int n = pq.length;
        for (int k = n/2; k > 1; k--) { // check video -> right half of n/2 is heap of size 1
            Heap.sink(pq,k,n);
        }

        while (n > 1) {
            Heap.exchange(pq,1,n);
            Heap.sink(pq,1,--n);
        }
    }
}
