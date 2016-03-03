package com.arrays.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * Given 2 strings , write a method to decide if one 
 * is a permutation of the other
 */

public class ThreePermutation {

	private static final String YES = "YES";
	private static final String NO = "NO";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter String");
		String str1 = br.readLine();
		System.out.print("Enter String");
		String str2 = br.readLine();
		System.out.println("Permutation ? " + checkPermutation(str1, str2));

	}

	/*
	 * 1. Solution from book. Sort the string and compare the strings
	 */

	private boolean permutation (String str1, String str2) {

		if (str1.length() != str2.length()) {
			return false;
		}	
		return sort(str1).equals(sort(str2));
	}

	private String sort (String str) {
		char[] chr1 = str.toCharArray();
		Arrays.sort(chr1);
		return chr1.toString();
	}
	
	/*
	 * Solution 2 : 
	 */
	private boolean permutation2(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		
		int[] letters = new int[128];
		for (char c : str1.toCharArray()) {
			letters[c]++;
		}
		for(char c : str2.toCharArray()) {
			if (--letters[c] < 0) {
				return false;
			}
		}
		return true;
	}
	private static String checkPermutation(String str1, String str2) {
		int[] arr1 = new int[128];
		int[] arr2 = new int[128];
		for (int i = 0; i < str1.length(); i++) {
			int val = str1.charAt(i);
			arr1[val]++;

		}
		for (int i = 0; i < str2.length(); i++) {
			int val = str2.charAt(i);
			arr2[val]++;

		}
		for (int i = 0; i < str2.length(); i++) {
			int val = str1.charAt(i);
			if (arr2[val] == 0 || arr2[val] != arr1[val])
				return NO;

		}
		return YES;
	}


}

/*
 * Comparison is case sensitive? white spaces to be considered ?
 * 
 */
