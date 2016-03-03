package com.lint.code;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindromeNumber(34543));
	}
	public static boolean isPalindrome(int x) {
		int rev = 0,num = 0;
		int Original = x;
		if (x < 0) {
			return false;
		}
		while (x != 0) {
			num = x%10;
			rev = rev*10 + num;
			x = x/10;
		}
		if (rev == Original) { 
			return true;
		}
		return false;
	}

	//Leet code solution : 
	//eg : 34543; checks for first and last digit ; if equal then makes x as 454 and repeats the process.

	public static boolean isPalindromeNumber(int x) {
		if (x < 0) return false;
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}
		while (x != 0) {
			int l = x / div;
			int r = x % 10;
			if (l != r) return false;
			x = (x % div) / 10;
			div /= 100; }
		return true;
	}


}
