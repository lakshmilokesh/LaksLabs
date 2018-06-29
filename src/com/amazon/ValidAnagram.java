package com.amazon;

/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 *
 */

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("ab","a"));
    }

    public static boolean isAnagram(String s, String t) {
        int[] letters = new int[128];

        if (s.length() != t.length())
            return false;
        for (Character c: s.toCharArray()) {
            letters[c]++;
        }
        for(Character c : t.toCharArray()) {
            if (--letters[c] < 0) {
                return false;
            }
        }
        return true;
    }

    //What if the inputs contain unicode characters? How would you adapt your solution to such case?
    //Use a hash table instead of a fixed size counter. Imagine allocating a large size array to fit the entire range
    // of unicode characters, which could go up to more than 1 million. A hash table is a more generic solution and
    // could adapt to any range of characters.
}
