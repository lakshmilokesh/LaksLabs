package com.googleMF;


/*
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *            or index number 5 where the peak element is 6.
 *
 *
 */
public class FindPeakElement {

    public static void main(String[] args) {

        int[] a = new int[]{9,8,7,6,5,4,3,2};
        System.out.println(searchRecursive(a,0,a.length-1));

    }

//    Complexity Analysis
//
//    Time complexity : O(n)O(n). We traverse the numsnums array of size nn once only.
//
//    Space complexity : O(1)O(1). Constant extra space is used.
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

//    Time complexity : O(logn). We reduce the search space in half at every step. Thus, the total search space will be
//    consumed in logn steps. Here, nn refers to the size of nums array.
//
//    Space complexity : O(logn) We reduce the search space in half at every step. Thus, the total search space will be
//    consumed in log n steps. Thus, the depth of recursion tree will go upto log_2(n)

    public static int searchRecursive(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return searchRecursive(nums, l, mid);
        return searchRecursive(nums, mid + 1, r);
    }

//    Complexity Analysis
//
//    Time complexity : O(logn) We reduce the search space in half at every step. Thus, the total search space will be
//    consumed in log n steps. Here, n refers to the size of nums array.
//
//    Space complexity : O(1). Constant extra space is used.

    public static int findPeakElementIterative(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }


}
