package com.InterviewQuestions;

/*
 * Solved by Lokesh
 *
 *
 */
public class AntiDiagonalSolution {
	
	static int[][] matrix = {{1,2,4},{3,5,7},{6,8,9}};
	
	static int[][] matrix4 = {{1,2,4,7},{3,5,8,11},{6,9,12,14},{10,13,15,16}};
	
	public static void main(String[] args) {
		printMatrix();
		System.out.println("==============================");
		printMatrixAntiDiagonal();
	}
	
	private static void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	private static void printMatrixAntiDiagonal() {
		int row = 0; int column = 0;
		while (column < matrix.length || row < matrix.length - 1) {	
			int m = (column == matrix.length)? row + 1: row;
			int n = (column == matrix.length)? column -1: column;
			do {
				System.out.print(matrix[m++][n--]+"\t");
			} while (isValid(m,n)); 
			System.out.println();
			if (column < matrix.length) {
				column++;
			} else {
				row++;
			}
		}
	}
	
	private static boolean isValid(int m, int n) {
		if (m < 0 || m >= matrix.length || n < 0 || n >= matrix.length) {
			return false;
		}
		return true;
	}
	
}
