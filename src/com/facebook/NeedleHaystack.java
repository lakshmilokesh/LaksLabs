package com.facebook;

/*
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 */
public class NeedleHaystack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("output ->" + strStr("aba","ba"));

	}
	public static int strStr(String haystack, String needle) {
		for (int i = 0; ; i++) {
			for (int j = 0; ; j++) {
				if (j == needle.length()) return i;
				if (i + j == haystack.length()) return -1;
				if (needle.charAt(j) != haystack.charAt(i + j)) break;
			} }
	}
}

