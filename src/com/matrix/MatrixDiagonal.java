package com.matrix;

public class MatrixDiagonal {

	static int[][] matrix = {{1,2,4},{3,5,7},{6,8,9}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printDiagonal();
	}

	public static void printDiagonal() {

		int n = matrix.length;

		for (int slice = 0; slice < 2 * n - 1; ++slice) {
			System.out.println("Slice: " + slice);
			int z = slice < n ? 0 : slice - n + 1;
			System.out.println("Value of Z: " + z);
			for (int j = z; j <= slice - z; ++j) {
				System.out.println("j ->" + j);
				System.out.println("slice-j  ->" + (slice-j));
				System.out.println(matrix[j][slice - j]);
			}
			System.out.println("===============================================");
			System.out.println();
		}

	}

}
