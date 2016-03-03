package com.arrays.strings;

public class Palindrome {
	
	public static void main(String[] args) {
		
		String input = "addeddam";
		
		System.out.println(isPalindrome(input));
		
	}
	
	private static boolean isPalindrome(String input) {
		return isPalindrome(input, 0, input.length()-1);
	}
	
	private static boolean isPalindrome(String input, int startIndex, int endIndex) {
		
		if (endIndex - startIndex <= 0) {
			return true;
		}
		
		if (input.charAt(startIndex) != (input.charAt(endIndex))) {
			return false;
		}
		
		return isPalindrome(input, startIndex+1, endIndex-1);
	}

}
