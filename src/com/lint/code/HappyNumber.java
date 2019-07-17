package com.lint.code;

import java.util.HashSet;
import java.util.Set;

/*
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive
 * integer, replace the number by the sum of the squares of its digits, and repeat the process
 * until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does
 * not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example: 19 is a happy number
 *
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 
 * SIMPLER SOLUTION : REFER AddDigits.java
 */
	public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		System.out.println(n + "is a happy number ?" + isHappy(n));
	}

	int digitSquareSum(int n) {
		int sum = 0, tmp;
		while (n > 0) {
			tmp = n % 10;
			sum += tmp * tmp;
			n /= 10;
		}
		return sum;
	}

	boolean isHappyNum(int n) {
		int slow, fast;
		slow = fast = n;
		do {
			slow = digitSquareSum(slow);
			fast = digitSquareSum(fast);
			fast = digitSquareSum(fast);
		} while(slow != fast);
		if (slow == 1) return true;
		else return false;
	}

    public static boolean isHappy(int n) {
        boolean happy = false;
        int sum = 0;
        Set<Integer> num = new HashSet<Integer>();
        while (!num.contains(n)) {
        	num.add(n);
        	while (n > 0) {
        		int digit = n%10;
        		sum = sum + (digit * digit);
        		n = n/10;
        	}
        	n = sum;
        	sum = 0;
        	System.out.println(n);
        	if (n == 1) {
        		return true;
        	}
        }
        return happy;
    }

}
