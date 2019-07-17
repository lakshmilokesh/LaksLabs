package com.amazon;

/*
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 
 */
public class SetMatrixZeroes {

	static int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setZeroes(matrix);
		for (int i = 0; i <  matrix.length; i++) {
			for (int j = 0;j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void setZeroes(int[][] matrix) {

		//checking if first row and column has zero
		int row = matrix.length;
		int column = matrix[0].length;

		boolean firstRow = false;
		boolean firstColumn = false;
		for (int i = 0; i < row; i++) {

			if (matrix[i][0] == 0) {
				firstColumn = true;
				break;
			}

		}

		for (int j = 0; j < column; j++) {
			if (matrix[0][j] == 0) {
				firstRow  = true;
				break;
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {

				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;

				}

			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			}
		}

		if (firstRow) {
			for (int i = 0; i < column ; i ++) {
				matrix[0][i] = 0;
			}
		}

		if (firstColumn) {
			for (int j = 0; j < row; j++) {
				matrix[j][0] = 0;
			}
		}

	}

}
