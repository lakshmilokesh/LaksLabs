package com.lint.code;

/*
 * 
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {

	private static final int[] values = {
		   1000, 900, 500, 400,
		   100,  90,  50,  40,
		   10,   9,   5,   4,
		   1 };
		private static final String[] symbols = {
		   "M", "CM", "D", "CD",
		   "C", "XC", "L", "XL",
		   "X", "IX", "V", "IV",
		   "I"
		};
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Roman Representation : " + intToRoman(13));
	}
	
	public static String intToRoman(int num) {
		   StringBuilder roman = new StringBuilder();
		   int i = 0;
		   while (num > 0) {
		      int k = num / values[i];
		      System.out.println("i->" + i + " values[i]->" + values[i] + " k->" + k);
		      for (int j = 0; j < k; j++) {
		         roman.append(symbols[i]);
		         num -= values[i];
		      }
		      i++; 
		   }
		   return roman.toString();
		}

}
