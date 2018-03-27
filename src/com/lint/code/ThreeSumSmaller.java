package com.lint.code;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 *
 * Return 2. Because there are two triplets which sums are less than 2:
 *
 * [-2, 0, 1]
 * [-2, 0, 3]
 * Follow up: Could you solve it in O(n2) runtime?
 *
 */
public class ThreeSumSmaller {


    public static void main(String[] args) {
        int[] arr = new int[]{-2, 0, 1, 3};
        int target = 2;
        System.out.println(threeSumSmaller(arr,target));
    }
    public static int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int result = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    result+=(k-j); // Since they are sorted , sum of a[i] + a[j..k] will be less than target as a[i]+a[i]+a[k] < target
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}
