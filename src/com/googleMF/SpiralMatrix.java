package com.googleMF;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 *
 */
public class SpiralMatrix {

	static int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
	//static int[][] matrix = {{2,3}};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> result = spiralOrder(matrix);
		System.out.println(result.toString());
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		if (matrix == null || matrix.length ==0 || matrix[0].length == 0)
			return result;
		
		int n = matrix.length;
		int m = matrix[0].length;
		int row = 0, col = -1;
		while (true) {
			for (int i = 0; i < m; i++) {
				result.add(matrix[row][++col]);
			}
			if (--n == 0)
				break;
			for (int j = 0; j < n; j++) {
				result.add(matrix[++row][col]);
			}
			if(--m == 0)
				break;
			for (int i = 0; i < m; i++) {
				result.add(matrix[row][--col]);
			}
			if (--n ==0)
				break;
			for (int j = 0;j <n;j++) {
				result.add(matrix[--row][col]);
			}
			if (--m == 0)
				break;
		}
		return result;
	}

}
