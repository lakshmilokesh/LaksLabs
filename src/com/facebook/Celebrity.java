package com.facebook;

/*
 * Imagine a room full of people, with only 1 celebrity in the room. Celebrity is defined as a person who does
 * not know anyone, but everyone knows him/her. Write a method who will take array of people and a person as
 * input and return boolean if the person is a celebrity or not.
 *
 * You are given a helper function bool knows(a, b) which tells you whether A knows B.
 * Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
 *
 *
 */

public class Celebrity {

// O(n) time O(1) Space Solution

    public int findCelebrity(int n) {
        if (n <= 1) {
            return -1;
        }

        int left = 0;
        int right = n - 1;

        // Step 1: Find the potential candidate
        while (left < right) {
            if (knows(left, right)) {
                left++;
            } else {
                right--;
            }
        }

        // Step 2: Validate the candidate
        int candidate = left;
        for (int i = 0; i < n; i++) {
            if (i != candidate && (!knows(i, candidate) || knows(candidate, i))) {
                return -1;
            }
        }

        return candidate;
    }

    //Below API will be provided
    private boolean knows(int left, int right) {
        return true;
    }

}
