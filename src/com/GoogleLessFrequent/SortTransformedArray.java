package com.GoogleLessFrequent;

/*
 * Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function of the form
 * f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)

Example:
nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

Result: [3, 9, 15, 33]

nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

Result: [-23, -5, 1, 7]
 *
 *
 */
public class SortTransformedArray {

    public static void main(String[] args) {


        int[] nums = new int[]{-4, -2, 2, 4};
        //Positive value of a
        //int a = 1,b = 3, c = 5;

        //Negative value of a
        int a = -1,b = 3, c = 5;
        int[] result = sortTransformedArray(nums,a,b,c);

        for (int i : result) {
            System.out.print(i + ",");
        }

    }

//    1.a>0, two ends in original array are bigger than center if you learned middle school math before.
//
//            2.a<0, center is bigger than two ends.
//
//    so use two pointers i, j and do a merge-sort like process. depending on sign of a, you may want to start from the
// beginning or end of the transformed array. For a==0 case, it does not matter what b's sign is.
//    The function is monotonically increasing or decreasing. you can start with either beginning or end.

    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] sorted = new int[n];
        int i = 0, j = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        while (i <= j) {
            if (a >= 0) {
                sorted[index--] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[i++], a, b, c) : quad(nums[j--], a, b, c);
            } else {
                sorted[index++] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[j--], a, b, c) : quad(nums[i++], a, b, c);
            }
        }
        return sorted;
    }

    public static int quad(int x, int a, int b,int c) {
        return ((a*x*x) + (b*x)+c);
    }
}
