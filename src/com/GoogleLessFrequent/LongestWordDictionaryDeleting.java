package com.GoogleLessFrequent;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some
 * characters of the given string. If there are more than one possible results, return the longest word with the smallest
 * lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output:
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output:
"a"
 *
 *
 *
 */

public class LongestWordDictionaryDeleting {


// Complexity Analysis
//
// Time complexity : O(n*x*logn + n*x). Here nn refers to the number of strings in list d and x
// refers to average string length. Sorting takes O(nlogn)O(nlogn) and isSubsequence takes O(x)O(x) to check whether a
// string is a subsequence of another string or not.
//
// Space complexity : O(logn)O(logn). Sorting takes O(logn)O(logn) space in average case.

    public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }

    public String findLongestWordSorting(String s, List< String > d) {
        Collections.sort(d, new Comparator< String >() {
            public int compare(String s1, String s2) {
                return s2.length() != s1.length() ? s2.length() - s1.length() : s1.compareTo(s2);
            }
        });
        for (String str: d) {
            System.out.println("str" + str);
            if (isSubsequence(str, s))
                return str;
        }
        return "";
    }


//    Complexity Analysis
//
//    Time complexity : O(n*x). One iteration over all strings is required. Here n refers to the number of strings
// in list d and xx refers to average string length.
//
//    Space complexity : O(x). max\_strmax_str variable is used.

    public String findLongestWord(String s, List < String > d) {
        String max_str = "";
        for (String str: d) {
            if (isSubsequence(str, s)) {
                if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0))
                    max_str = str;
            }
        }
        return max_str;
    }


}
