package com.googleMF;

/*
 * For some fixed N, an array A is beautiful if it is a permutation of the integers 1, 2, ..., N, such that:
 *
 * For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] + A[j].
 *
 * Given N, return any beautiful array A.  (It is guaranteed that one exists.)
 *
 *
 *
 * Input: 4
 * Output: [2,1,4,3]
 *
 * Input: 5
 * Output: [3,1,2,5,4]
 *
 *
 */

import java.util.HashMap;
import java.util.Map;

public class BeautifulArray {

    static Map<Integer, int[]> memo;

    public static void main(String[] args) {

        int[] result = beautifulArray(4);
    }

    public static int[] beautifulArray(int N) {
        memo = new HashMap();
        return f(N);
    }

    public static int[] f(int N) {
        if (memo.containsKey(N))
            return memo.get(N);

        int[] ans = new int[N];
        if (N == 1) {
            ans[0] = 1;
        } else {
            int t = 0;
            for (int x: f((N+1)/2))  // odds
                ans[t++] = 2*x - 1;
            for (int x: f(N/2))  // evens
                ans[t++] = 2*x;
        }
        memo.put(N, ans);
        return ans;
    }


}
