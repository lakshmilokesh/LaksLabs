package com.facebook;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * Question asked in Amazon and Facebook
 */

public class CountAndSay {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter the value of n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sequence = Integer.parseInt(br.readLine());
		System.out.println("Sequence" + countAndSay(sequence));

	}
	public static String countAndSay(int n) {

		String start = "1";
		char charj = start.charAt(0);
		int count = 0;

		for (int i = 0; i < n-1; i++) {
			StringBuffer sb = new StringBuffer();
			
			for (int j = 0; j < start.length(); j++) {
				count = 1;
				charj = start.charAt(j);
				while (j+1 < start.length() && charj == start.charAt(j+1)) {
					count++;
					j++;
				}
				sb.append(count).append(charj);
			}			
			start = sb.toString();
		}
		return start;
	}

}
