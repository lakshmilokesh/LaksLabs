package com.googleMF;

/*
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You
 * are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right]
 * coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 *
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 *
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *            coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 *
 *
 */

public class BurstBalloons {

    public static void main(String[] args) {
        int[]  nums = new int[]{3,1,5,8};
        System.out.println(maxCoins(nums));
    }

    public static int maxCoins(int[] nums) {
        int[] result = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) if (x > 0) result[n++] = x;
        result[0] = result[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            result[left] * result[i] * result[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }
}
