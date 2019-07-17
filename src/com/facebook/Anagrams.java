package com.facebook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given an array of words, write a method that determines whether there are any words in this array that are anagrams
 * of each other.
 *
 * There should be a better way to do without using sort
 */
public class Anagrams {

    public static void main(String[] args) {
        String[] words = new String[]{"bag","bat","tab"};
        System.out.println(solve(words));
    }
    public static boolean solve(String[] input) {
        Set<String> dict = new HashSet<>();

        for (String elem : input) {
            char[] array = elem.toCharArray();
            Arrays.sort(array);
            String target = new String(array);
            if (!dict.contains(target)) {
                dict.add(target);
            }
        }
        if (dict.size() == 1) {
            return true;
        }
        return false;
    }
}
