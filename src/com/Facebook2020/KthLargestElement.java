package com.Facebook2020;

import com.sorting.QuickSort;

import java.util.Collections;
import java.util.Random;

/*
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not
 * the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 */

public class                                                                                                                                                                                                                          KthLargestElement {

    public static void main(String[] args) {

        int[] num = new int[]{2,1};
        System.out.println("kth Largest element :  " + findKthLargest(num,1));
    }

    public static int findKthLargest(int[] nums, int k) {
        nums = shuffle(nums);
        int lo = 0, hi = nums.length-1;
        int kLargest_num = nums.length - k;
        while (lo <= hi) {
            int j = QuickSort.partition(nums,lo,hi);
            if (kLargest_num > j)
                lo = j+1;
            else if(kLargest_num < j)
                hi = j-1;
            else
                return nums[kLargest_num];


        }
        return nums[kLargest_num];
    }

    public static int[] shuffle(int[] n) {
        Random r = new Random();
        int j, temp;
        for (int i = 0; i< n.length; i++) {
            j = r.nextInt(i+1);
            temp = n[j];
            n[j] = n[i];
            n[i] = temp;
        }
        return n;
    }
}
