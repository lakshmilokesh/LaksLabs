package com.facebook;

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

/*
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 *
 * x is guaranteed to be a non-negative integer.
 *
 * SOLUTION : The square root of an integer n is within [1, n/2 + 1]. Thus we can binary search from 1 to n/2 + 1.
 * If the square root of the middle is less than n, the target must be in the left part. Else it must be in the right part.
 *
 */
public class SquareRoot {

    public static void main(String[] args) {
        System.out.println("Square Root -> " + sqrt(25));
    }

    public static int sqrt(int x) {
        if (x == 0) {
            return 0;
        }

        if (x < 0) {
            return -1;
        }

        long lo = 0;
        long hi = x / 2 + 1;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long sq = mid * mid;
            if (sq == x) {
                return (int) mid;
            }

            if (sq < x) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return (int) hi;
    }
}
