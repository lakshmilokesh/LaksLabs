package com.leet.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Laks on 2/2/16.
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty
 * word in str.
 *
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by
 * a single space.
 *
 */
public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "cat dog cat cat";
        System.out.println("result : " + wordPattern(pattern,str));
    }

    public static boolean wordPattern(String pattern, String str) {
        Map<String, Character> patternMap = new HashMap<String, Character>();
        Set<Character> words = new HashSet<Character>();
        StringBuilder strb = new StringBuilder();

        if (pattern == null || str == null || pattern == "" || str == "") {
            return false;
        }
        String[] s = str.split(" ");
        char[] pat = pattern.toCharArray();

        if (s.length != pat.length)
            return false;
        for (int i = 0, j = 0; i < pattern.length(); i++, j++) {
            if (!patternMap.containsKey(s[i])) {
                if (words.contains(pat[j]))
                    return false;
                words.add(pat[j]);
                patternMap.put(s[i], pat[j]);

            }
            strb.append(patternMap.get(s[i]));
        }
        System.out.println(strb.toString());
        if (pattern.equals(strb.toString()))
            return true;
        return false;
    }
}