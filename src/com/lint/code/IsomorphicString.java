package com.lint.code;

import java.util.HashMap;
import java.util.Map;



/*
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving
 * the order of characters. No two characters may map to the same character but a character may map
 * to itself.
 *
 * For example,
 * Given "egg", "add", return true.
 *
 * Given "foo", "bar", return false.
 *
 * Given "paper", "title", return true.
 */
public class IsomorphicString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ab";
		String t = "aa";
		System.out.println("isIsomorphic->" + isIsomorphic(s, t));

	}

	//Better approach

	public boolean isIsomorphicString (String s, String t) {
		int[] m1 = new int[256];
		int[] m2 = new int[256];
		int n = s.length();
		if (s.length() != t.length())
			return false;
		for (int i = 0; i < n; i++) {
			if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
			m1[s.charAt(i)] = i + 1;
			m2[t.charAt(i)] = i + 1;
		}
		return true;
	}

	//My Solution
		public static boolean isIsomorphic(String s, String t) {

			boolean isIsomorphic = false;
			if (s.length() != t.length())
				isIsomorphic = false;
			int strlength = s.length();
			StringBuilder new_string = new StringBuilder(strlength);
			Map<Character,Character> charmap = new HashMap<Character,Character>();
			boolean[] dup = new boolean[128];
			
			for (int i = 0,j=0; i < strlength; i++,j++) {
				char c = s.charAt(i);
					
				if (!charmap.containsKey(c)) {
					while (j < strlength && dup[t.charAt(j)]) {
						j++;
					}
					if (j < strlength) {
						dup[t.charAt(j)] = true;
						charmap.put(c, t.charAt(j));
					}
					
				}
				new_string.append(charmap.get(c));
			}

			if (t.equals(new_string.toString()))
				isIsomorphic = true;
			return isIsomorphic;
		}

}
