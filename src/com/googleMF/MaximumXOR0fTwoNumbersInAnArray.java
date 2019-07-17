package com.googleMF;

/*
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 *
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 *
 * Could you do this in O(n) runtime?
 *
 * Input: [3, 10, 5, 25, 2, 8]
 *
 * Output: 28
 *
 * Explanation: The maximum result is 5 ^ 25 = 28.
 *
 */

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.util.HashSet;
import java.util.Set;

public class MaximumXOR0fTwoNumbersInAnArray {

    // I DO NOT UNDERSTAND THE SOLUTION
    public static void main(String[] args) {

        int[] nums = new int[]{3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR(nums));
    }


    public static int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
