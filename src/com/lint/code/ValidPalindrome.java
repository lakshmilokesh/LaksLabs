package com.lint.code;

/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Below is a Facebook Interview Question
 *
 * Given a string "L*&EVe)))l", write a method which will determine if the input is a palindrome.
 * Ignore all special characters. Uppercase/lowercase should be considered as same.
 *
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("is palindrome ? " + isPalindrome("race a car"));
	}

	/*
	 * Leet code
	 */

	public boolean palindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
			if (Character.toLowerCase(s.charAt(i))
					!= Character.toLowerCase(s.charAt(j))) {
				return false;
			}
			i++; j--;
		}
		return true;
	}
	
	/*
	 * my code
	 */
	public static boolean isPalindrome(String s) {
		String str = redefineString(s);
		int length = str.length();
		int j = 0;
		while (j <= length) {
			if (str.charAt(j) == str.charAt(length-1)) {
				j++;
				length--;
			}
			else
				return false;
		}
		return true;
	}

	private static String redefineString(String s) {
		// TODO Auto-generated method stub
		int strlength = s.length();
		StringBuffer sb = new StringBuffer();
		String supper = s.toUpperCase();
		int i = 0;
		while(i < strlength) {
			if (supper.charAt(i) >= 65 && supper.charAt(i) <= 90) {
				sb.append(supper.charAt(i));

			}
			i++;
		}
		return sb.toString();
	}

}
