package com.GoogleLessFrequent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its
 * missing ranges.
 *
 * Example:
 *
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 *
 *
 */
public class MissingRanges {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3, 50, 75};
        int lo =0, hi = 99;
        System.out.println(findMissingRanges(nums,lo,hi));
    }

    public static List<String> findMissingRanges(int[] a, int lo, int hi) {
        List<String> res = new ArrayList<String>();

        // the next number we need to find
        int next = lo;

        for (int i = 0; i < a.length; i++) {
            // not within the range yet
            if (a[i] < next) continue;

            // continue to find the next one
            if (a[i] == next) {
                next++;
                continue;
            }

            // get the missing range string format
            res.add(getRange(next, a[i] - 1));

            // now we need to find the next number
            next = a[i] + 1;
        }

        // do a final check
        if (next <= hi) res.add(getRange(next, hi));

        return res;
    }

    static String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }
}
