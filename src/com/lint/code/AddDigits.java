package com.lint.code;

/*
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * 
 */
public class AddDigits {

	private static int num = 38;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSingleDigit(num));
		System.out.println(getOneDigit(num));
	}
	
	//Solution 1 : Brute Force
	private static int getSingleDigit(int num) {
		int sum = 0;
		while (num > 9) {
			sum = sum + num%10;
			num = num/10;
		}
		sum = sum + num;
		if (sum > 9)
			sum = getSingleDigit(sum);
		return sum;
	}
	
	//without loop/recursion
	private static int getOneDigit(int num) {
		if(num == 0) return 0;
		if(num % 9 == 0) return 9;
		return num % 9;
		}

}
