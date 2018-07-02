package com.GoogleLessFrequent;
/*
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
 *
 *
 */

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c","ad#c"));
    }

    public static boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }
//    Complexity Analysis
//
//    Time Complexity: O(M + N), where M, N are the lengths of S and T respectively.
//
//    Space Complexity: O(M + N).
    public static String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }

}
