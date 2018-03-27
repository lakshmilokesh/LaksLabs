package com.lint.code;


/*
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 * 
 */
public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("output->" + numSquares(4));
	}

	public static int numSquares(int n) {
		if (n <= 0) {
			return 0;
		}

		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
				System.out.println("dp["+i+"]->" + dp[i]);
			}
		}
		return dp[n];
	}


}
