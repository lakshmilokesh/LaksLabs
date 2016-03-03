package com.arrays.strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Implement a function void reverse(char[] str) - reverses a null terminated string
 * Best Approach.. have 2 pointers. one in the beginning and one in the end and swap.
 * N/2 complexity
 */
public class TwoCharArrReverse {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the string");
		String s = br.readLine();
		// Best Approach
		System.out.println("1. Best Approach->" + stringReverseBest(s));
		
		System.out.println("1. Reversed string" + stringReverse(s));
		System.out.println("2. Reversed String Buffer string" + stringBufferReverse(s));
		System.out.println("3. Reversed String Buffer string" + stringReverseUsingStringBuffer(s));
	}
	private static String stringReverseBest(String input) {
		int j = input.length()-1;
		int i = 0;
		char[] a = input.toCharArray();
		while (i < j) {
			char temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		String output = new String(a);
		return output;
	}
	private static void swap(char[] input, int i, int j) {

		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	private static String stringReverse(String input) {
		int size = input.length();
		char[] reverse = new char[size];
		
		for (int j = size-1, i = 0; j >= 0 ; j--, i++) {
			reverse[i] = input.charAt(j);
		}
		return new String(reverse);
	}
	
	private static String stringReverseUsingStringBuffer(String input) {
		int size = input.length();
		StringBuffer str = new StringBuffer();
		for (int j = size-1; j >= 0 ; j--) {
			str.append(input.charAt(j));
		}
		return str.toString();
	}
	
	private static String stringBufferReverse (String input) {

		StringBuffer str = new StringBuffer(input);
		return str.reverse().toString();
	}

}
