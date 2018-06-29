package com.googleMF;

/**
 * Created by Laks on 1/19/16.
 *
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 *
 */
public class PowerOfThree {

    public static void main(String[] args) {
        System.out.println(powerOfThree(1234569));
        System.out.println(isPowerOfThree(1234569));
    }

    /*
     * With loops
     */
    public static boolean powerOfThree(int n) {

        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /*
     *
     */
    public static boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }


}
