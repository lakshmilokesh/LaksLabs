package com.InterviewQuestions;

/**
 * Created by Laks on 2/18/16.
 *
 * ServiceNow Interview 2016
 *
 */
public class Permutation {

    public static void main(String[] args) {
        permutation("abc");
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        System.out.println("prefix->   " + prefix + " :: String->   " + str);
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }

}
