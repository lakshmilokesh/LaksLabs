package com.facebook;

/**
 * Implement a function OneEditApart with the following signature:
 * bool OneEditApart(string s1, string s2)
 *
 * isOneEditDistance("cat", "dog") = false
 * isOneEditDistance("cat", "cats") = true
 * isOneEditDistance("cat", "cut") = true
 * isOneEditDistance("cat", "cast") = true
 * isOneEditDistance("cat", "at") = true
 * isOneEditDistance("cat", "acts") = false
 *
 * Solution
 * Assume X represents the one-edit character. There are three one-edit distance operations
 * that could be applied to S.
 *
 * i. Modify operation – Modify a character to X in S.
 * S = “abcde”
 * T = “abXde”
 *
 * ii. Insert operation – X was inserted before a character in S.
 * S = “abcde”
 * T = “abcXde”
 *
 * iii. Append operation – X was appended at the end of S.
 * S = “abcde”
 * T = “abcdeX”
 *
 * O(n) runtime, O(1) space – Simple one-pass:
 *
 */
public class OneEditDistance {

    public static void main(String[] args) {

//        System.out.println(isOneEditDistance("cat", "dog")); //false
//        System.out.println(isOneEditDistance("cat", "cats"));//true
//        System.out.println(isOneEditDistance("cat", "cut")); //true
//        System.out.println(isOneEditDistance("cat", "cast")); //true
//        System.out.println(isOneEditDistance("cat", "at")); //true
        System.out.println(isOneEditDistance("cat", "acts")); // false
    }

    public static boolean isOneEditDistance(String s, String t) {

        int short_len = s.length(), long_len = t.length();

        if (short_len > long_len)
            return isOneEditDistance(t, s);

        if (long_len - short_len > 1)
            return false;

        int i = 0, diff = long_len - short_len;

        // We make a first pass over S and T concurrently and stop at the first non-matching
        // character between S and T.
        while (i < short_len && s.charAt(i) == t.charAt(i)) i++;

        // If S matches all characters in T, then check if there is an extra character at the end
        // of T. (Append operation)
        if (i == short_len) return diff > 0;

        // If | n – m | == 0, then we skip both non-matching characters in S and T and make
        // sure the remaining characters between S and T are exactly matching.
        // (Modify operation)
        if (diff == 0) i++;

        // If | n – m | == 1, that means we must skip this non-matching character only in T
        // and make sure the remaining characters between S and T are exactly matching.
        // (Insert operation)
        while (i < short_len && s.charAt(i) == t.charAt(i + diff)) i++;
        return i == short_len;
    }

}
