package com.lint.code;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * SOLUTION
 * 
 * The person can reach n’th stair from either (n-1)’th stair or from (n-2)’th stair. Let the total number
 * of ways to reach n’t stair be ‘ways(n)’. The value of ‘ways(n)’ can be written as following.
 *
 * ways(n) = ways(n-1) + ways(n-2)
 * The above expression is actually the expression for Fibonacci numbers, but there is one thing to notice, the value
 * of ways(n) is equal to fibonacci(n+1).
 *
 * ways(1) = fib(2) = 1
 * ways(2) = fib(3) = 2
 * ways(3) = fib(4) = 3
 * 
 */
public class ClimbStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ways to climb stairs : " + climbStairs(3));
	}
    public static int climbStairs(int n) {
    	return fibonacci(n+1);
    }
    
	private static int fibonacci(int n) {
		int f = 0;
		int[] fib = new int[n+1];
		for (int i = 1; i <= n;i++) {
			if (i <= 2) {
				f = 1;
			}
			else {
				f = fib[i-1] + fib[i-2];
			}
			fib[i] = f;
		}
		return fib[n];
	}

    }
