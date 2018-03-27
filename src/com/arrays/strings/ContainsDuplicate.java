package com.arrays.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

/*
 * Given an array of integers, find if the array contains any duplicates. Your function should return
 * true if any value appears at least twice in the array, and it should return false if every element
 * is distinct.
 */
public class ContainsDuplicate {

	private static int[] nums = new int[]{1,5,-2,-4,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(containsDuplicateNum(nums));
	}

	// Time complexity: O(N lg N), memory: O(1) - not counting the memory used by sort

	public static boolean containsDuplicateNum(int[] nums) {

		Arrays.sort(nums);
		for(int ind = 1; ind < nums.length; ind++) {
			if(nums[ind] == nums[ind - 1]) {
				return true;
			}
		}
		return false;
	}

	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> dups = new HashSet<Integer>();
		for (int val : nums) {
			if(dups.contains(val)) {
				return true;	
			}
			else {
				dups.add(val);
			}
		}
		return false;
	}

}
