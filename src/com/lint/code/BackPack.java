package com.lint.code;

/**
 * @param m: An integer m denotes the size of a backpack
 * @param A: Given n items with size A[i]
 * @return: The maximum size
 *
 * NOT A WORKING CODE
 */
public class BackPack {

	public static void main(String[] args) {

		int[] A = new int[]{16,16,3,5,16,16,16,16,16,16,16,16,16,16,16,16,16};
		int m = 100;
		System.out.println("BackPack size ->" + backPack(m,A));

	}

	// TODO Auto-generated method stub
	public static int backPack(int m, int[] A) {
		// write your code here
		int sum = 0;
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			sum = A[i];
			for (int j = i+1; j < A.length; j++) {
				sum = sum +A[j];
				if (sum > m)
					sum = sum - A[j];
			}
			System.out.println("Sum->" + sum);
			if (sum > max)
				max = sum;

		}
		return max;
	}
}



