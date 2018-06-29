package com.facebook;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Laks on 3/16/16.
 *
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example,
     * "code" -> False, "aab" -> True, "carerac" -> True.
 *
 *
 * Understand the problem:
 * The problem can be easily solved by count the frequency of each character using a hash map. The only thing need
 * to take special care is consider the length of the string to be even or odd.
 * -- If the length is even. Each character should appear exactly times of 2, e.g. 2, 4, 6, etc..
 * -- If the length is odd. One and only one character could appear odd times.

 */
public class PalindromePermutation {

    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("code"));
    }

    public static boolean canPermutePalindrome(String s) {
        if (s== null || s.length() < 1) {
            return true;
        }
        char[] characters = s.toCharArray();
        Map<Character,Integer> palindromeMap = new HashMap<Character, Integer>();
        for (char c : characters) {
            if (palindromeMap.containsKey(c)) {
                palindromeMap.put(c,palindromeMap.get(c)+1);

            }
            else {
                palindromeMap.put(c,1);
            }

        }

        int tol = 0;
        for (Map.Entry val : palindromeMap.entrySet()){
           if ((int)val.getValue()%2 != 0) {
               tol++;
           }
        }
        if (s.length() %2 == 0)
            return tol == 0;
        else
            return tol == 1;
    }
}
