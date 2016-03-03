package com.leet.code;

/*
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(26));
	}
	
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n>0) {
        	n = n/5;
        	count = count + n;
        	
        }
    	return count;
    }

	
}
