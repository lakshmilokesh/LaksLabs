package com.InterviewQuestions2019;

/*
 * Atlassian 2020
 *
 * Give an array of integers like below,find the number that occurs only one. Number wil be repeated only twice and will
 * be in sorted order.
 *
 * [0,1,1,2,2,3,3] => 0
 * [0,0,1,1,2,2,3] => 3
 * [0,0,1,1,2,3,3] => 2
 
 The idea is based on the following two facts. 
a) XOR of a number with itself is 0. 
b) XOR of a number with 0 is number itself.
 *
 *
 */
public class FindSingleNumber {
  
    // Return the maximum Sum of difference
    // between consecutive elements.
    static int findSingle(int ar[], int ar_size)
    {
        // Do XOR of all elements and return
        int res = ar[0];
        for (int i = 1; i < ar_size; i++)
            res = res ^ ar[i];
     
        return res;
    }
 
    // Driver code
    public static void main (String[] args)
    {
        int ar[] = {2, 3, 5, 4, 5, 3, 4};
        int n = ar.length;
        System.out.println("Element occurring once is " +
                            findSingle(ar, n) + " ");
    }
}
