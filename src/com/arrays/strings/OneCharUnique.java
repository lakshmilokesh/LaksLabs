package com.arrays.strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Determine if a string has all unique characters. Do not use additional data structure.
 * 
 * Questions : ASCII OR Unicode String
 * There are only 128 possible unique characters
 * Time complexity : o(n)
 * Space Complexity : o(1)
 * Another approach : sort the string and check neighboring characters are identical 
 * (Many Sorting algorithm take extra space)
 * 
 */
public class OneCharUnique {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter String");
		String s = br.readLine();
		if (checkUniqueness(s))
			System.out.println("Unique");
		else
			System.out.println("Not Unique");

	}

	private static boolean checkUniqueness(String input) {
		
		boolean[] checkArr = new boolean[128];
		for (int i = 0; i <input.length(); i++) {
			int val = input.charAt(i);
			if (checkArr[val]) {
				return false;
			}
			checkArr[val] = true;
		}
		return true;
	}
}
