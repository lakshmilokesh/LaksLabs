package com.arrays.strings;

/**
 * A magic index in an array A[1---n-1] is defined to be an index such that A[i] = i. Given a sorted array of distinct
 * integers, write a method to find a magic index, if one exists in array A.
 *
 * FOLLOW UP
 *
 * What if the values are not distinct
 *
 */
public class MagicIndex {

    public static void main(String[] args) {

        int[] a = new int[]{-40,-20,-1,1,2,3,5,7,9,12,13};
        System.out.println(magicIndex(a));

        //FOLLOW UP
        int[] b = new int[]{-10,-5,2,2,2,3,4,7,9,12,13};
        System.out.println("Distinct : " + findMagicIndexDistinct(b,0,b.length));
    }

    public static int magicIndex(int[]a) {
        int index = findMagicIndex(a,0,a.length);
        return index;
    }
    public static int findMagicIndex(int[] a, int start, int end) {

        if (end < start || start < 0 || end > a.length)
            return -1;
        int mid = (start+end)/2;
        if (a[mid] == mid)
            return mid;
        else if (a[mid] < mid)
            return findMagicIndex(a,mid+1,end);
        else
            return findMagicIndex(a,start,mid-1);
    }

    //FOLLOW UP : What if values are not distinct

    public static int findMagicIndexDistinct(int[] a, int start, int end) {

        if (end < start || start < 0 || end > a.length)
            return -1;
        int midIndex = (start+end)/2;

        if (a[midIndex] == midIndex)
            return midIndex;

        //Search Left
        int index = Math.min(midIndex-1,a[midIndex]);
        int leftIndex = findMagicIndexDistinct(a,start,index);
        if (leftIndex >= 0)
            return leftIndex;

        //Search right
        int rightIndex = Math.max(midIndex+1,a[midIndex]);
        int right = findMagicIndexDistinct(a,rightIndex,end);
        return right;

    }

}
