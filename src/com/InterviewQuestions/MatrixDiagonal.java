package com.InterviewQuestions;
/*
 * Google Phone interview 2015
 *
 * Iterate through a matrix anti diagonally:
 *
 * 1 2 4
 * 3 5 7
 * 6 8 9
 *
 * should print in the natural order of “1, 2, 3, 4, 5, 6, 7, 8, 9”
 *
 * Try:
 * a b c
 * d e f
 * g h i
 *
 *
 */

public class MatrixDiagonal {

	static int[][] matrix = {{1,2,4},{3,5,7},{6,8,9}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loopDiag(matrix);

	}

	public static void loopDiag(int [][] b) {

		int n = matrix.length;
		for (int slice = 0; slice < 2 * n - 1; ++slice) {
			int z = slice < n ? 0 : slice - n + 1;
			for (int j = z; j <= slice - z; ++j) {
				System.out.println(matrix[j][slice - j]);
			}
			System.out.println();
		}
	}
}
