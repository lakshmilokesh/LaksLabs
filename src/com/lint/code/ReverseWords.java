package com.lint.code;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Reverse ->" + reverseWords("Sky is blue"));
		
	}
	
	public static String reverseWords(String s) {
		   StringBuilder reversed = new StringBuilder();
		   int j = s.length();
		   for (int i = s.length() - 1; i >= 0; i--) {
		      if (s.charAt(i) == ' ') {
		         j = i;
		      } else if (i == 0 || s.charAt(i - 1) == ' ') {
		         if (reversed.length() != 0) {
		            reversed.append(' ');
		         }
		         reversed.append(s.substring(i, j));
		      }
		}
		   return reversed.toString();
		}

}
