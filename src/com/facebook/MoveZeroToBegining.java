package com.facebook;


/*
 * Given an array of integers, move all non-zero integers to the beginning of the array and return the number
 * of non-zero integers. The memory can be assumed to be volatile.  
 *
 *
 */
public class MoveZeroToBegining {

    public static void main(String[] args) {

        int[] arr = new int[] {0,2,3,0,5,7,0,9};
        moveZeros(arr);

    }

    private static void moveZeros(int[] arr) {
        int i = arr.length-1, j = arr.length-1;
        while(i >=0) {
            if(arr[i] != 0) {
                arr[j--] = arr[i--];
            }
            else {
                i--;
            }
        }

        while (j >= 0) {
            arr[j--] = 0;
        }

        for(int k : arr) {
            System.out.print(k + " ");
        }
    }

}
