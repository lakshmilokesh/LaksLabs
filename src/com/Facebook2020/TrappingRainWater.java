package com.Facebook2020;

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining.
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water
 * (blue section) are being trapped.
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * Complexity analysis
 *
 * Time complexity: O(n)O(n).
 * Single iteration of O(n)O(n) in which each bar can be touched at most twice(due to insertion and deletion from stack) and insertion and deletion from stack takes O(1)O(1) time.
 * Space complexity: O(n)O(n). Stack can take upto O(n)O(n) space in case of stairs-like or flat structure.
 *
 *
 *
 */

import java.util.Stack;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] a = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(a));
    }

    public static int trap(int[] height)
    {
        int ans = 0, current = 0;
        Stack<Integer> st = new Stack<>();
        while (current < height.length) {
            while (!st.empty() && height[current] > height[st.peek()]) {
                int top = st.peek();
                st.pop();
                if (st.empty())
                    break;
                int distance = current - st.peek() - 1;
                int bounded_height = Math.min(height[current], height[st.peek()] - height[top]);
                ans += distance * bounded_height;
            }
            st.push(current++);
        }
        return ans;
    }
}
