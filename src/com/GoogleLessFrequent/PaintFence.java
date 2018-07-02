package com.GoogleLessFrequent;

/*
 * There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.

Example:

Input: n = 3, k = 2
Output: 6
Explanation: Take c1 as color 1, c2 as color 2. All possible ways are:

            post1  post2  post3
 -----      -----  -----  -----
   1         c1     c1     c2
   2         c1     c2     c1
   3         c1     c2     c2
   4         c2     c1     c1
   5         c2     c1     c2
   6         c2     c2     c1
 *
 *
 */

public class PaintFence {

    public static void main(String[] args) {

        System.out.println(numWays(3,2));
    }

    public static int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;
        if (n == 1) return k;
        // same[i] means the ith post has the same color with the (i-1)th post.
        int[] same = new int[n];
        // diff[i] means the ith post has a different color with the (i-1)th post.
        int[] diff = new int[n];
        same[0] = same[1] = k;
        diff[0] = k;
        diff[1] = k * (k - 1);
        for (int i = 2; i < n; ++i) {
            // the i-th in same should be equal the previous one in diff since only two consectutive
            // same are allowed
            same[i] = diff[i-1];

            // the i-th in diff should be either different from its previous one or from the one
            // before the previous one
            diff[i] = (k - 1) * same[i-1] + (k - 1) * diff[i-1];
        }
        return same[n-1] + diff[n-1];
    }
}
