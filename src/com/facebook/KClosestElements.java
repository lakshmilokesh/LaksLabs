package com.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array.
 * The result should also be sorted in ascending order. If there is a tie, the smaller elements are always
 * preferred.
 *
 * Example 1 :
 *
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 *
 * Example 2:
 * Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 *
 */
public class KClosestElements {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        List<Integer> list = new ArrayList();
        list.add(1); list.add(2); list.add(4); list.add(5); list.add(6);

        System.out.println(findClosestElementsArray(arr,4,-1));
    }

    public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int n = arr.size();
        if (x <= arr.get(0)) {
            return arr.subList(0, k);
        } else if (arr.get(n - 1) <= x) {
            return arr.subList(n - k, n);
        } else {
            int index = Collections.binarySearch(arr, x);
            // if x is not present. x would have been inserted
            // at position index. So the function returns (-index-1)
            // which is -index.
            if (index < 0)
                index = -index - 1;
            int low = Math.max(0, index - k - 1), high = Math.min(arr.size() - 1, index + k - 1);

            while (high - low > k - 1) {
                if (low < 0 || (x - arr.get(low)) <= (arr.get(high) - x))
                    high--;
                else if (high > arr.size() - 1 || (x - arr.get(low)) > (arr.get(high) - x))
                    low++;
                else
                    System.out.println("unhandled case: " + low + " " + high);
            }
            return arr.subList(low, high + 1);
        }
    }

    public static List<Integer> findClosestElements1(List<Integer> arr, int k, int x) {
        int n = arr.size();
        if (x <= arr.get(0)) {
            return arr.subList(0, k);
        } else if (arr.get(n - 1) <= x) {
            return arr.subList(n - k, n);
        } else {
            int index = Collections.binarySearch(arr, x);
            if (index < 0) index = -index - 1;

            int low = index; int high = index;

            while ((high - low) != k) {
                if ( high + 1 < arr.size() - 1) {
                    high++;
                }
                if ((low - 1) > -1) {
                    low--;
                }
            }
            return arr.subList(low, high);
        }
    }

    public static List<Integer> findClosestElementsArray(int[] arr, int k, int x) {
        List<Integer> ll = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int n = ll.size();
        if (x <= arr[0]) {
            return ll.subList(0, k);
        } else if (arr[n - 1] <= x) {
            return ll.subList(n - k, n);
        } else {
            int index = Collections.binarySearch(ll, x);
            if (index < 0) index = -index - 1;

            int low = index;
            int high = index;

            while ((high - low) != k) {
                if (high + 1 < n - 1) {
                    high++;
                }
                if ((low - 1) > -1) {
                    low--;
                }
            }
            return ll.subList(low, high);
        }
    }
}
