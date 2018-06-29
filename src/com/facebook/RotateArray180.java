package com.facebook;

import java.util.Map;
import java.util.HashMap;
/*
 *
 * Question 1: Given an input of an array of string, verify if, turned 180 degrees, it is the "same".
 * For instance:
 * [1, 6, 0, 9, 1] => return true
 * [1, 7, 1] => return false
 *
 *
 */

public class RotateArray180 {

    public static void main(String[] args) {
        String[] arr = new String[]{"1", "7", "1"};
        System.out.println(check180(arr));

    }

    private static boolean check180(String[] arr) {
        int length = arr.length;
        Map<String,String> matcher = new HashMap<String, String>();
        matcher.put("0","0");
        matcher.put("1","1");
        matcher.put("6","9");
        matcher.put("8","8");
        matcher.put("9","6");

        boolean oddLength = (length % 2 != 0);
        if(oddLength && (!arr[length/2].equals("8") && !arr[length/2].equals("0") && !arr[length/2].equals("1"))) {
            return false;
        }

        //int half = oddLength ? (length/2)+1 : length/2;
        int i = 0;
        int j=length-1;
        for(;i<length/2;i++,j--) {
            if(!matcher.get(arr[i]).equals(arr[j])) {
                return false;
            }
        }
        return true;
    }
}
