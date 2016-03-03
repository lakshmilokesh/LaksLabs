package com.arrays.strings;


/*
 * Write an efficient  program to find the sum of contiguous subarray within a one-dimensional
 * array of numbers which has the largest sum.
 *
 * Kadane’s Algorithm:
 *
 * Initialize:
 *   max_so_far = 0
 *   max_ending_here = 0
 *
 * Loop for each element of the array
 * (a) max_ending_here = max_ending_here + a[i]
 * (b) if(max_ending_here < 0)
 *           max_ending_here = 0
 * (c) if(max_so_far < max_ending_here)
 *           max_so_far = max_ending_here
 * return max_so_far
 * 
 * 
 * NOTE : Algorithm doesn't work for all negative numbers. It simply returns 0 if all numbers are negative.
 * For handling this we can add an extra phase before actual implementation. The phase will look if all
 * numbers are negative, if they are it will return maximum of them (or smallest in terms of absolute value).
 * There may be other ways to handle it though.
 * 
 */
public class LargestSumContiguousSubarray {

	private static final int[] arr = new int[]{-2,-3,-5,-3};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findlargestSumSubarray(arr));
	}

	//Handles negative numbers - Effective
	public static int findlargestSumSubarray(int[] arr) {
		int max_so_far = arr[0];
		int curr_max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			curr_max = Math.max(arr[i], curr_max+arr[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}
	
	public static int findlargestSum(int[] arr) {

		int sum_temp = 0, sum_final = 0;
		for (int val : arr) {
			sum_temp = sum_temp + val;

			if (sum_temp < 0)
				sum_temp = 0;

			else if (sum_final < sum_temp) 
				sum_final = sum_temp;
		}

		return sum_final;
	}



}
