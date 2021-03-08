package com.Interview2021;


/*
 * /*
 * Given an integer print all factors of the number. Number may  be negative number
 *
 * Facebook Phone interview
 *
 * A row-sorted binary matrix means that all elements are 0 or 1 and each row of the matrix is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return the index (0-indexed) of the leftmost column with a 1 in it. If such an index does not exist, return -1.

You can't access the Binary Matrix directly. You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
BinaryMatrix.dimensions() returns the dimensions of the matrix as a list of 2 elements [rows, cols], which means the matrix is rows x cols.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes, the input will be the entire binary matrix mat. You will not have access to the binary matrix directly.
 *
 *
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 *
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 *
 */

public class LeftmostColumnWithLeastOne {


    public int leftMostColumnWithOne(int[][] binaryMatrix) {
        int rows = binaryMatrix.length;
        int cols = binaryMatrix[0].length;

        // Set pointers to the top-right corner.
        int currentRow = 0;
        int currentCol = cols - 1;

        // Repeat the search until it goes off the grid.
        while (currentRow < rows && currentCol >= 0) {
            if (binaryMatrix[currentRow][currentCol] == 0) {
                currentRow++;
            } else {
                currentCol--;
            }
        }

        // If we never left the last column, this is because it was all 0's.
        return (currentCol == cols - 1) ? -1 : currentCol + 1;
    }
}
