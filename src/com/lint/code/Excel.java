package com.lint.code;

/**
 * Source : https://oj.leetcode.com/problems/excel-sheet-column-title/
 * Author : Hexiaoqiao
 * Date   : 2014-12-24
 *
 * 0.Problem:
 * 0.1
 * Given a positive integer, return its corresponding column title as 
 * appear in an Excel sheet.
 * For example:
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB 
 * 0.2
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its 
 * corresponding column number.
 * For example:
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 * 
 * 1.Refer.:
 */


public class Excel {


	public static int titleToNumber(String s) {

		int len = s.length();
		double sum = 0;
		double p = 0;
		for (int i = len-1; i >= 0; i--) {
			char c = s.charAt(i);
			sum = sum + ((c - 'A' +1) * Math.pow(26, p));
			p++;
		}
		return new Double(sum).intValue();

	}

	public static String numberToTitle(int n) {
		StringBuffer sb = new StringBuffer();
		int rem = 0;
		while (n > 0) {
			rem = n%26;
			if (rem == 0)
				rem = 26;
			sb.append((char) ('A' + rem - 1));
			System.out.println();
			if (rem ==26) 
				n = n/26-1;
			else
				n = n/26;
		}

		return sb.reverse().toString();

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int i = 299; i < 300; i++) {
			System.out.println(i + ".Corresponding column ->" + numberToTitle(i));
			System.out.println("Title to Number -> " + titleToNumber(numberToTitle(i)));
		}
	}
}