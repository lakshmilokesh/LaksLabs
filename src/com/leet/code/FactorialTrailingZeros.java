package com.leet.code;

/*
 * Given an integer n, return the number of trailing zeroes in n!.
 * The idea is to consider prime factors of a factorial n. A trailing zero is always produced by prime factors 2 and 5.
 * If we can count the number of 5s and 2s, our task is done. Consider the following examples.
 *
 * n = 5: There is one 5 and 3 2s in prime factors of 5! (2 * 2 * 2 * 3 * 5). So count of trailing 0s is 1.
 *
 * n = 11: There are two 5s and three 2s in prime factors of 11! (2 8 * 34 * 52 * 7). So count of trailing 0s is 2.
 *
 * We can easily observe that the number of 2s in prime factors is always more than or equal to the number of 5s.
 * So if we count 5s in prime factors, we are done.
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
