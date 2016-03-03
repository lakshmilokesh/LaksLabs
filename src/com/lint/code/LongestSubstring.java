package com.lint.code;


public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("length" + lengthOfLongestSubstring("abacdn"));

	}

	public static int lengthOfLongestSubstring(String s) {
		boolean[] exist = new boolean[256];
		////Map<String,Integer> substr = new HashMap<String, Integer>();
		int i = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			while (exist[s.charAt(j)]) {
				exist[s.charAt(i)] = false;
				i++;
			}
			exist[s.charAt(j)] = true;
			System.out.println("substr-->" + s.substring(i, j+1));
			maxLen = Math.max(j - i + 1, maxLen);
			
		}
		return maxLen;
	}

}
