package com.googleMF;

/*
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 *
 */

public class PowerOfTwo {

    public static void main(String[] args) {
        isPowerOfTwo(8);
    }

    public static boolean isPowerOf2(int n) {
        if (n <= 0) {
            return false;
        }

        while (n > 1) {
            if (n%2 != 0)
                return false;
            n /= 2;
        }
        return true;
    }
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        int ones = 0;
        //The int data type is a 32-bit signed
        for (int i = 1; i <= 32; ++i) {
            ones += n & 1;
            n = n >> 1;
        }
        return ones == 1;
    }
}
