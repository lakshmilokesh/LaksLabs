package com.amazon;

/*
 * Implement atoi to convert a string to an integer.
 *
 */
public class  StringToInt {

	private static final int maxDiv10 = Integer.MAX_VALUE / 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		System.out.print(maxDiv10);
	}

	public static int strToInt( String str ){
		int i = 0;
		int num = 0;
		boolean isNeg = false;

		//Check for negative sign; if it's there, set the isNeg flag
		if (str.charAt(0) == '-') {
			isNeg = true;
			i = 1;
		}

		//Process each character of the string;
		while( i < str.length()) {
			num *= 10;
			//Minus the ASCII code of '0' to get the value of the charAt(i++).
			num += str.charAt(i++) - '0';
		}

		if (isNeg)
			num = -num;
		return num;
	}

	//Leet Code solution : handles overflow and underflow
	//using str.charAt(i) == ' ' takes less time than Character.isWhitespace(str.charAt(i)

	public int atoi(String str) {
		int i = 0, n = str.length();
		while (i < n && Character.isWhitespace(str.charAt(i))) i++;
		int sign = 1;
		if (i < n && str.charAt(i) == '+') {
			i++;
		} else if (i < n && str.charAt(i) == '-') {
			sign = -1;
			i++; }
		int num = 0;
		while (i < n && Character.isDigit(str.charAt(i))) {
			int digit = Character.getNumericValue(str.charAt(i));

			if (num > maxDiv10 || num == maxDiv10 && digit >= 8) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			num = num * 10 + digit;
			i++;
		}
		return sign * num;
	}

}
