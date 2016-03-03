package com.InterviewQuestions;

/*
 * AOL Coding interview 2015
 */
public class Aol1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(17,31));
	}

    public static int solution1(int A, int B) {
        // write your code in Java SE 8
    	StringBuffer a = new StringBuffer();
    	int result = A*B;
    	int count = 0;
    	while (result > 0) {
    		if (result%2 == 1) 
    			count++;
    		result = result/2;
    	}
    	
    	return count;
    }
    
    public static int solution(int A, int B) {
        // write your code in Java SE 8
    	long result = (long)A*B;
    	System.out.println(result);
    	int oneCount = 0;
    	while (result > 0) {
    		if ((result & 1L) == 1) {
    			oneCount++;
    		}
    		result = result >> 1;
    	}
    	
    	return oneCount;
    }
}
