package com.apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Laks on 1/14/16.
 *
 * In a stream of integers from 1 to n, only one number will be repeated. How can you tell what that number is?
 */
public class RepeatedNumber {

    public static void main(String args[]) {
        int[] a= new int[]{1,2,3,5,3,3,3,4};
        int num = findNumber(a);
        System.out.println(num);

    }

    private static int findNumber(int[] a) {
        boolean[] arr = new boolean[a.length];
        for (int i = 0;i < a.length; i++) {

            if (arr[a[i]])
                return a[i];
            arr[a[i]] = true;

        }
        return 0;
    }

}
