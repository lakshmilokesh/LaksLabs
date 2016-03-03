package com.InterviewQuestions;
/*
 * AOL interview Question 1
 *
 *  A[0] =  1
 *  A[1] =  4
 *  A[2] = -1
 *  A[3] =  3
 *  A[4] =  2
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = new int[]{1,4,-1,3,2};
		int[] A = new int[]{-1};
		System.out.println(solution(A));
	}

    public static int solution(int[] A) {

    	//Validate for null and empty array
    	if (A == null || A.length == 0) {
    		return 0;
    	}
    	
    	int index = 0;
    	int length = 1;
    	while (A[index] != -1) {
    		index = A[index];
    		length++;
    	}
    	return length;
    }
}
