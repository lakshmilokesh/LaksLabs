package com.amazon;

/*
 * You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.
 *
 * For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine to one
 * of its adjacent washing machines at the same time .
 *
 * Given an integer array representing the number of dresses in each washing machine from left to right on the line, you
 * should find the minimum number of moves to make all the washing machines have the same number of dresses. If it is
 * not possible to do it, return -1.
 *
 * Input: [1,0,5]
 *
 * Output: 3
 *
 * Explanation:
 * 1st move:    1     0 <-- 5    =>    1     1     4
 * 2nd move:    1 <-- 1 <-- 4    =>    2     1     3
 * 3rd move:    2     1 <-- 3    =>    2     2     2
 *
 * Input: [0,3,0]
 *
 * Output: 2
 *
 * Explanation:
 * 1st move:    0 <-- 3     0    =>    1     2     0
 * 2nd move:    1     2 --> 0    =>    1     1     1
 *
 * Input: [0,2,0]
 *
 * Output: -1
 *
 * Explanation:
 * It's impossible to make all the three washing machines have the same number of dresses.
 *
 */

public class SuperWashingMachines {

    public static void main(String[] args) {
        int[] arr = new int[]{0,3,0};
        System.out.println(findMinMoves(arr));
    }
    public static int findMinMoves(int[] machines) {
        int n = machines.length, dressTotal = 0;
        for (int m : machines) dressTotal += m;
        if (dressTotal % n != 0) return -1;

        int dressPerMachine = dressTotal / n;
        // Change the number of dresses in the machines to
        // the number of dresses to be removed from this machine
        // (could be negative)
        for (int i = 0; i < n; i++) machines[i] -= dressPerMachine;

        // currSum is a number of dresses to move at this point,
        // maxSum is a max number of dresses to move at this point or before,
        // m is number of dresses to move out from the current machine.
        int currSum = 0, maxSum = 0, tmpRes = 0, res = 0;
        for (int m : machines) {
            currSum += m;
            maxSum = Math.max(maxSum, Math.abs(currSum));
            tmpRes = Math.max(maxSum, m);
            res = Math.max(res, tmpRes);
        }
        return res;
    }
}
