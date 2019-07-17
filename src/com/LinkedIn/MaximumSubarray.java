package com.LinkedIn;

/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum
 * and return its sum.
 *
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] input = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(input));
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)  return 0;
        int sum=nums[0];
        int max=nums[0];
        for (int i =1 ; i < nums.length; i++) {
            if (sum < 0)
                sum = nums[i];
            else
                sum = sum + nums[i];

            if (max <  sum)
                max = sum;
        }
        return max;
    }


    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0)  return 0;
        int curr_max = nums[0];
        int max_so_far = nums[0];

        for (int i = 1; i < nums.length;i++) {
            curr_max = Math.max(curr_max+nums[i], nums[i]);
            max_so_far = Math.max(curr_max, max_so_far);
        }
        return max_so_far;
    }


}
