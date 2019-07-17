package com.lint.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of size n, find the majority element. The majority element is the element that
 * appears more than ⌊ n/2 ⌋ times
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Also refer majority element in strings/MajorityElement
 */
public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[] {6,5,5}; 
		System.out.println("Majority element" + majorityElement(num));

	}
	
	/*
	 * Using Hash map
	 */
	public static int majorityElement(int[] num) {
		Map<Integer,Integer> check = new HashMap<Integer,Integer>();
		Integer counter = 0;
		int max = num[0];
		check.put(max, 0);
		for (int i : num) {
			if (check.containsKey(i)) {
				counter = check.get(i);
				check.put(i, ++counter);
				if (counter > num.length/2) {
					max = i;
					break;
				}
			}
			else {
				check.put(i,1);
			}
		}

		/*for (int i : check.keySet()) {
			System.out.println(i + "->" + check.get(i));
			if(check.get(i) > check.get(max))
				max = i;
		}*/

		return max;
	}
	
	/*
	 * Without using additional data structure
	 */
	public static int majorityElementCheck(int[] num) {
		Arrays.sort(num);
		return num[num.length/2];
	}
	
}
