package com.LinkedIn;

/**
 * Created by Laks on 2/18/16.
 *
 * o(n!) time as we know there are n! permutations
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
        System.out.println("Prefix : " + prefix + "| Str : " + str);

        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {

            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);
                String before = str.substring(0,i);
                String after = str.substring(i+1,n);
                permutation(prefix + c, before+after);
            }
        }
    }

}
