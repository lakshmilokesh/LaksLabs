package com.googleMF;


/*
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.

 *
 * HINT : Scan from left bottom to right top/ right top to left bottom
 * Time complexity : 0 (m + n)
 *
 * Time complexity : \mathcal{O}(n+m)O(n+m)

The key to the time complexity analysis is noticing that, on every iteration (during which we do not return true) either row or col is is decremented/incremented exactly once. Because row can only be decremented mm times and col can only be incremented nn times before causing the while loop to terminate, the loop cannot run for more than n+mn+m iterations. Because all other work is constant, the overall time complexity is linear in the sum of the dimensions of the matrix.

Space complexity : \mathcal{O}(1)O(1)

Because this approach only manipulates a few pointers, its memory footprint is constant.
 *
 */
public class SearchMatrix2 {

	static int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 17;
		searchMatrix(matrix, target);
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int row = 0;
		int col = matrix[0].length-1;
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == target)
				return true;
			if (matrix[row][col] < target)
				row++;
			else
				col--;
		}
		return false;
	}

}
