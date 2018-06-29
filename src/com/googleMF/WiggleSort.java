package com.googleMF;

/*
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 *
 * Example:
 *
 * Input: nums = [3,5,2,1,6,4]
 * Output: One possible answer is [3,5,1,6,2,4]
 *
 *
 */

import java.util.Arrays;

public class WiggleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,2,1,6,4};
        wiggleSort2(nums);
    }

//    Complexity analysis
//
//    Time complexity : O(nlogn). The entire algorithm is dominated by the sorting step, which costs O(nlogn) time to
//    sort n elements.
//
//    Space complexity : O(1). Space depends on the sorting implementation which, usually, costs O(1) auxiliary space if
//    heapsort is used.

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//    Complexity analysis
//
//    Time complexity : O(n). In the worst case we swap at most n/2 times. An example input is [2,1,3,1,4,1].
//
//    Space complexity : O(1).

    public static void wiggleSort2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (((i % 2 == 0) && nums[i] > nums[i + 1])
                    || ((i % 2 == 1) && nums[i] < nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }
}
