package com.facebook;

import java.util.Map;
import java.util.HashMap;

/*
 * Question asked in Google as well
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose
 * sum equals to k.
 *
 *
 * Example:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 *
 */

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1};
        System.out.println("result => " + subarraySum(arr,2));
    }

    public static int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
