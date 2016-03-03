package com.bit.manipulation;

/*
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has
 *(also known as the Hamming weight).
 *
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
 * so the function should return 3.
 * 
 * 
 * 
 */
public class NumberOfOneBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("no of 1 s" + hammingWeight(11));
	}
	
	public static int hammingWeight(int n) {
	    int count = 0;
	   /* while (n > 0) {
	    	if ((n & 1L) == 1)
	    		count++;
	    	n = n >> 1;
	    }*/
	    for(int i=1; i<33; i++){
	        if(getBit(n, i) == true){
	            count++;
	        }
	    }
	    return count;
	}
	 
	public static boolean getBit(int n, int i){
	    return (n & (1 << i)) != 0;
	}

}
