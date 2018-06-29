package com.lint.code;

/*
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * The time complexity of this solution is O(m * n), where m is the length of the LCP string,
 * n is the number of strings in the array.
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = new String[3];
		strs[0] = "aa";
		strs[1] = "aa";
		strs[2] = "arjun";
		System.out.println("Longest Common Prefix-> " + longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {

		int arrLength = strs.length;
		String first = "";
		if (arrLength > 0) {
			first = strs[0];
			for (int i = 0; i < strs[0].length(); i++) {
				char c = first.charAt(i);
				for (int j = 1; j < arrLength; j++) {
					if (i >=  strs[j].length() || c != strs[j].charAt(i)) {
						return first.substring(0, i);
					}
				}
			}
		}
		return first;
	}

}
