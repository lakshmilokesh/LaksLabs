package com.facebook;

/*
 * Given an array of integers, find two integers that sum to zero. How would you do it with three integers?  
 */

import java.util.Arrays;

public class SumAddToZero {

    //o(n/2)
    public  static int[] twoSum(int[] a) {
        Arrays.sort(a);
        int i =0, j = a.length-1;
        while (i <= j) {
            int sum = a[i]+a[j];
            if (sum == 0) {
                break;
            }
            if(sum < 0)
                i++;
            if (sum > 0)
                j--;
        }
        return new int[]{i,j};
    }

    // refer Binary searchin sorted two sum

    //Refer Threesum problem in lint.code package



}
