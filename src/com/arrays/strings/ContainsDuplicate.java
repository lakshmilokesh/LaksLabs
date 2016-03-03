package com.arrays.strings;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of integers, find if the array contains any duplicates. Your function should return
 * true if any value appears at least twice in the array, and it should return false if every element
 * is distinct.
 */
public class ContainsDuplicate {

	private static int[] nums = new int[]{1,5,-2,-4,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(containsDuplicate(nums));
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
