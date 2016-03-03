package com.arrays.strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Perform string compression using the counts of repeated characters. aabcccccaaa
 * would become a2b1c5a3.if the compressed string is greater than the original
 * string return the original string.  
 */
public class FiveStringCompression {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter String");
		String str1 = br.readLine();
		System.out.println("Compressed String->" + compressString(str1));
	}

	private static String compressString(String str) {

		StringBuffer s = new StringBuffer();
		int i = 0;
		while (i < str.length()) {
			char ichar = str.charAt(i);
			int count = 1;
			for (int j = i+1; j < str.length(); j++) {
				if (ichar != str.charAt(j)) {
					break;
				}
				count++;
			}
			i = i+count;
			s.append(ichar);
			s.append(count);
		}
		return s.toString();
	}
}
