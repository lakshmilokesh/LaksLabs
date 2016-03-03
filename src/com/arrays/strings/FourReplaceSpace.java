package com.arrays.strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Replace all spaces in a string with '%20'. Use character array
 */
public class FourReplaceSpace {

	public static final char SPACE = ' ';
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter String");
		String str1 = br.readLine();
		System.out.println("Replaced String->" + replaceSpace(str1));
	}

	private static String replaceSpace(String str1) {
		// TODO Auto-generated method stub
		int count = countSpace(str1);
		int arr_size = str1.length() + (count*2);
		char[] new_arr = new char[arr_size];
		for (int i = str1.length()-1; i >=0; i-- ) {
			if (SPACE == str1.charAt(i)) {
				new_arr[arr_size-3] = '%';
				new_arr[arr_size-2] = '2';
				new_arr[arr_size-1] = '0';
				arr_size = arr_size-3;
			}
			else {
				new_arr[arr_size-1] = str1.charAt(i);
				arr_size = arr_size-1;
			}
			
		}
		return new String(new_arr);
	}

	private static int countSpace(String str1) {
		// TODO Auto-generated method stub
		int count = 0;
		for (char c : str1.toCharArray()) {
			if (SPACE == c) {
				count++;
			}
		}
		return count;
	}

}
