package com.lint.code;

/*
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 */


import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("length" + lengthOfLongestSubstring("pwuwkew"));

	}

	public static int lengthOfLongestSubstring(String s) {
		boolean[] exist = new boolean[256];
		int i = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			Character c = s.charAt(j);
			while (exist[c]) {
				exist[s.charAt(i)] = false;
				i++;
			}
			exist[c] = true;
			maxLen = Math.max(j - i + 1, maxLen);

		}
		return maxLen;
	}
	
}
