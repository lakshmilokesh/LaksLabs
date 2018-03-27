package com.facebook;

import java.util.Arrays;
import java.util.List;

/**
 * Write a function that takes a string S and an array of strings A and returns true if S can be reconstructed by any
 * combination of the elements in A.
 */
public class ReconstructString {

    public static void main(String[] args) {

        String S = "I Am Am Laks";
        String[] A = new String[]{"I","Am","A","Little","Late","Laks"};
        System.out.println(reconstructString(S,A));
    }
    public static boolean reconstructString(String S, String[] A) {

        String[] stringRef = S.split(" ");
        int length = stringRef.length;
        int count = 0;
        List<String> l = Arrays.asList(A);
        for (String str : stringRef) {
            if(l.contains(str)) {
                count++;
            }
        }
        if (count >= length)
            return true;
        else
            return false;
    }
}
