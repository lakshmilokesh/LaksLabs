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
		System.out.println("Reverse->" + reverse(sequence));

	}
	public static int reverse(int x) {

		long rev = 0;
		while(x != 0){
			rev = rev*10 + x%10;
			x = x/10;
			if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
				return 0;
		}
		return (int)rev;

	}

}
