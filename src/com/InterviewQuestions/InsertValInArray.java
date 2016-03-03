package com.InterviewQuestions;

/**
 * Created by Laks on 2/18/16.
 *
 * ServiceNow 2016
 *
 * Given a key and array of integers sorted in ascending order. Insert the key in the array. Array has empty places
 * filled with -1. It can hold negative integers also.
 *
 * Example array
 * [3,5,6,7,9,-1,-1,-1]
 *
 */
public class InsertValInArray {

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,-1,-1};
        insert(arr,6);
    }
    public static void insert(int[] arr, int val) {
        int size = arr.length;

        for (int i = size-1; i >= 0; i--) {
            while (arr[i] == -1)
                i--;

            if (val > arr[i]) {
                arr[i+1] = val;
                break;
            }
            arr[i+1] = arr[i];
        }
        if (val < arr[0]) {
            arr[0] = val;
        }
        //printing
        for (int j : arr) {
            System.out.println(j);
        }
    }
}
