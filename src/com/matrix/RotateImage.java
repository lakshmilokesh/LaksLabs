package com.matrix;

/*
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 *
 * For array 1    2
             3    4 ,
 * the transformed array is     3     1
                                4     2
 *
 *     For array 1  2  3
                 4  5  6
                 7  8  9
 * the transformed array is                7  4  1
                                           8  5  2
                                           9  6  3
 *
 *
 *
 */

public class RotateImage {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1,2,3,4},{6,7,8,9},{11,12,13,14},{16,17,18,19}};
        rotateInPlace(matrix);
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void rotateOutPlace(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int [][] temp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j< cols; j++) {
                temp[i][j] = matrix[rows-j-1][i];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j< cols; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }

    }

    /*
     * In-place Solution:
     * An in-place method is to first transpose the array, then swap the elements in each row.
     * For example, for array
     * 1  2  3
     * 4  5  6
     * 7  8  9
     * The transposed array is:
     * 1  4  7
     * 2  5  8
     * 3  6  9
     * Then swap elements in each row
     * 7  4  1
     * 8  5  2
     * 9  6  3
     *
     *
     */
    public static void rotateInPlace(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int temp;

        // transpose of a matrix
        for (int i = 0; i < rows; i++) {
            for (int j = i+1; j< cols; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        //swap elements in each row
        int mid = rows/2;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j< mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][rows - j - 1];
                matrix[i][rows - j - 1] = tmp;
            }
        }

    }

}
