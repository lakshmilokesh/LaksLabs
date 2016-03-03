package com.sorting;

/**
 * Created by Laks on 1/8/16.
 *
 * Binary Heap Properties
 *
 * 1. Largest Key is a[1] -> Root of the Binary Tree
 * 2. Parent of Node K is at K/2
 * 3. Children of Node K are at 2k and 2k+1
 *
 */
public class Heap {

    static int[] pq = new int[10];
    static int n = pq.length;
    /*
     * Promotion in a Heap : Child's key is larger than parents key.
     * Exchange child and parent key
     * Repeat until heap order is restored
     */

    public static void swim(int[] a, int k) {
        while (k > 1 && a[k] > a[k/2]) {
            exchange(a,k,k/2);
            k = k/2;
        }
    }

    /*
     * Insertion in a HEAP.
     *
     * Add node at the end and swim it up
     */
    public static void insert(int x) {
        pq[++n] = x;
        swim(pq,n);
    }

    /*
     * Demotion in a HEAP
     *
     * Parents key becomes smaller than one(or both) of its children
     *
     * 1. Exchange key in parent with key in larger child
     * 2. Repeat until Heap order is restored
     */
    public static void sink(int[]a, int k, int N) {

        while (2*k <= N) {
            int j = 2*k;
            if (j < N && a[j] < a[j+1]) {
                j++;
            }
            if (a[k] > a[j])
                break;
            exchange(a,k,j);
            k =  j;
        }
    }

    /*
     * Delete MAX in the heap
     *
     *
     */
    public static int deleteMax() {
        int max = pq[1];
        exchange(pq,1,n--);
        sink(pq,1,n);
        pq[n+1]= 0;
        return max;
    }
    public static void exchange(int[] a, int k, int i) {
        int temp = a[k];
        a[k] = a[i];
        a[i] = temp;
    }
}
