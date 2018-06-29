package com.amazon;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) 
 * are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 * 
 * SOLUTION 1: BRUTE FORCE
 * Runtime : 0(n2)
 * Space : 0(1)
 * 
 * SOLUTION 2 : Hashtable
 * Runtime : 0(n)
 * Space : 0(n)
 * 
 */
public class TwoSum {

	private static final int[] numbers = new int[]{2,3,7,11,15};
	private static final int target = 9;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] output = twoSum(numbers, target);
		if (output != null)
			System.out.println("index1=" + output[0] + " ,index2=" + output[1]);
	}
	
    public static int[] twoSum(int[] nums, int target) {
    	Map<Integer,Integer> intMap = new HashMap<Integer, Integer>();
    	for (int i = 0; i < nums.length; i++) {
    		if (intMap.containsKey(target-nums[i])) {
    			return new int[]{intMap.get(target-nums[i]) + 1, i+1};
    		}
    		intMap.put(nums[i], i);
    	}
        return null;
    }

}
