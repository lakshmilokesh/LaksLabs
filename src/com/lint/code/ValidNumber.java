package com.lint.code;

public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("is numeric ->" + isNumber("."));

	}
	
	public static boolean isNumber(String s) {
		   int i = 0, n = s.length();
		   while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		   if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
		   boolean isNumeric = false;
		   while (i < n && Character.isDigit(s.charAt(i))) {
			   i++;
		      isNumeric = true;
		   }
		   if (i < n && s.charAt(i) == '.') {
		      i++;
		      while (i < n && Character.isDigit(s.charAt(i))) {
		         i++;
		         isNumeric = true;
		      }
		}
		if (isNumeric && i < n && s.charAt(i) == 'e') {
		   i++;
		   isNumeric = false;
		   if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
		   while (i < n && Character.isDigit(s.charAt(i))) {
		i++;
		      isNumeric = true;
		   }
		}
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		   return isNumeric && i == n;
		}
	

}
