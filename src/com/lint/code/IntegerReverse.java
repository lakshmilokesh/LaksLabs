package com.lint.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * Input : 1534236469
 *
 */
public class IntegerReverse {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter the integer");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sequence = Integer.parseInt(br.readLine());
		System.out.println("Reverse->" + reverse(1534236469));

	}
	public static int reverse(int x) {

		boolean neg =  (x < 0) ? true:false;

		int rev = 0;
		x = (neg)? x*-1 : x;
		while(x > 0){

			if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && x%10 == 8))
				return 0;
			rev = rev*10 + x%10;
			x = x/10;

		}
		rev = (neg)? rev*-1 : rev;
		return rev;

	}

}
