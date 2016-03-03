package com.leet.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Laks on 2/1/16.
 *
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the difference between i and j is at most k.
 */
public class ContainsDuplicate2 {

    public static void main(String[] args) {

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer,Integer> dups = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (dups.containsKey(nums[i])) {
                int j = dups.get(nums[i]);
                if (i-j <= k)
                    return true;
            }
            dups.put(nums[i],i);

        }
        return false;
    }
}