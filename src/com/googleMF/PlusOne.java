package com.googleMF;

import java.util.ArrayList;
import java.util.List;


/*
 * Given a non-negative number represented as an array of digits, plus one to the number.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Given [1,2,3] which represents 123, return [1,2,4].
 *
 * Given [9,9,9] which represents 999, return [1,0,0,0].
 */
public class PlusOne {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<Integer>  a = new ArrayList<Integer>();
		a.add(9);
		a.add(9);
		a.add(9);

		plusOne(a);
		System.out.println( "list result" + a.toString());
		//array
		int[] chek = new int[]{9,9};
		chek = plusOne(chek);

		
		for (int i = 0; i < chek.length; i++) {
			System.out.println(chek[i]);
		}


	}

	public static void plusOne(List<Integer> digits) {
		for (int i = digits.size() - 1; i >= 0; i--) {
			int digit = digits.get(i);
			if (digit < 9) {
				digits.set(i, digit + 1);
				return;
			} else {
				digits.set(i, 0);
			}
		}
		digits.add(0);
		digits.set(0, 1);
	}

	public static int[] plusOne(int[] digits) {

		int length = digits.length;
		
		for (int i = length-1; i >= 0; i--) {
			int number = digits[i];
			if (number < 9) {
				digits[i] = number+1;
				return digits;
			}
			else {
				digits[i] = 0;
			}
		}
		digits = new int[length+1];
		digits[0] = 1;
		return digits;
	}

}
