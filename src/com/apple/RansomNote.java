package com.apple;

/*
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function
 * that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 *
 */
public class RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstruct("a","b"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] characters = new int[26];
        for (char c : magazine.toCharArray()) {
            characters[c-'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (--characters[c-'a'] < 0)
                return false;
        }

        return true;

    }
}
