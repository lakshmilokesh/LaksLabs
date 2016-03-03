package com.matrix;


import java.util.ArrayList;
import java.util.List;

/*
 * 
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 *
 *
 */
public class SpiralMatrix2 {

	public static void main(String[] args) {

		List<List<Integer>> finalMatrix = new ArrayList<List<Integer>>();
		List<Integer> content = null;
		int[][] matrix = generateMatrix(3);
		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = 0; i < n; i++) {
			content = new ArrayList<Integer>();
			for (int j = 0; j < m; j++) {
				content.add(matrix[i][j]);
			}
			finalMatrix.add(content);
		}

		//Printing as per requirement
		System.out.println(finalMatrix);
	}
	
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        //n = rows, m cols
        int m = n;
        int row = 0, col = -1;
        int val =1;
        while (true) {
        	
        	for (int i = 0; i < m; i++) {
        		matrix[row][++col] = val++;
        	}
        	
        	if (--n == 0) 
        		break;
        	
        	for (int i = 0; i < n; i++) {
        		matrix[++row][col] = val++;
        	}
        	
        	if (--m == 0)
        		break;
        	
        	for (int i = 0; i < m; i++) {
        		matrix[row][--col] = val++;
        	}
        	
        	if (--n == 0)
        		break;
        	
        	for (int i = 0; i < n; i++) {
        		matrix[--row][col] = val++;
        	}
        	
        	if (--m == 0)
        		break;
        	
        }
        return matrix;
    }
}
