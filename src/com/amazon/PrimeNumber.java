package com.amazon;

/*
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * SOLUTION
 * 
 * 
 * The Sieve of Eratosthenes is one of the most efficient ways to find all prime numbers up to n. 
 * 
 * HINTS
 * -----
 * 
 * Let's write down all of 12's factors:
 *
 * 2 × 6 = 12
 * 3 × 4 = 12
 * 4 × 3 = 12
 * 6 × 2 = 12
 * As you can see, calculations of 4 × 3 and 6 × 2 are not necessary. Therefore, we only need to consider
 * factors up to √n because, if n is divisible by some number p, then n = p × q and since p ≤ q, we could
 * derive that p ≤ √n.
 * 
 * We start off with a table of n numbers. Let's look at the first number, 2. We know all multiples of 2
 * must not be primes, so we mark them off as non-primes. Then we look at the next number, 3. Similarly,
 * all multiples of 3 such as 3 × 2 = 6, 3 × 3 = 9, ... must not be primes, so we mark them off as well.
 * Now we look at the next number, 4, which was already marked off. 
 * 
 * 4 is not a prime because it is divisible by 2, which means all multiples of 4 must also be divisible
 * by 2 and were already marked off. So we can skip 4 immediately and go to the next number, 5. Now,
 * all multiples of 5 such as 5 × 2 = 10, 5 × 3 = 15, 5 × 4 = 20, 5 × 5 = 25, ... can be marked off.
 * There is a slight optimization here, we do not need to start from 5 × 2 = 10. 
 * 
 * In fact, we can mark off multiples of 5 starting at 5 × 5 = 25, because 5 × 2 = 10 was already marked off by multiple of 2,
 * similarly 5 × 3 = 15 was already marked off by multiple of 3. Therefore, if the current number is p,
 * we can always mark off multiples of p starting at p2, then in increments of p: p2 + p, p2 + 2p, ...
 * 
 */
public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPrimes(15));
	}
	
    public static int countPrimes(int n) {
    	int count = 0;
    	boolean[] prime = new boolean[n];
    	for (int i = 2; i < n; i++) {
    		prime[i] = true;
    	}
    	// Loop's ending condition is i * i <= num instead of i <= sqrt(num)
        // to avoid repeatedly calling an expensive function sqrt().
    	for (int i = 2; i*i < n; i++) {
    		if (!prime[i])
    			continue;
    		for (int j = i*i; j < n; j+=i) {
    			prime[j] = false;
    		}
    	}
    	
    	for (int i = 2; i < n ; i++) {
    		System.out.println("i->" + i + "val->" + prime[i]);
    		if (prime[i]) {
    			count++;
    		}
    	}
        return count;
    }

}
