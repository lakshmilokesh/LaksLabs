package com.leet.code;

/*
 * You are a professional robber planning to rob houses along a street. Each house has a
 * certain amount of money stashed, the only constraint stopping you from robbing each of them
 * is that adjacent houses have security system connected and it will automatically contact the
 * police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 */
public class HouseRobbery {

	public static int[] num = new int[]{50,1,1,100};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rob(num));
	}
	/*
	 * Dynamic Programming
	 * The key is to find the relation dp[i] = Math.max(dp[i-1], dp[i-2]+num[i-1]).
	 */
	public static int robDp(int[] num) {
		
		if (num == null || num.length == 0)
			return 0;
		int n = num.length;
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = num[0];
		
		for (int i = 2; i < n+1; i++) {
			dp[i] = Math.max(dp[i-2] + num[i-1], dp[i-1]);
		}
		return dp[n];
	}
	
	
	public static int rob(int[] num) {
		if(num==null || num.length == 0)
			return 0;
	 
		int even = 0;
		int odd = 0;
	 
		for (int i = 0; i < num.length; i++) {
			if (i % 2 == 0) {
				even += num[i];
				even = even > odd ? even : odd;
			} else {
				odd += num[i];
				odd = even > odd ? even : odd;
			}
		}
	 
		return even > odd ? even : odd;
	}

}
