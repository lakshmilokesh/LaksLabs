package com.GoogleLessFrequent;

/*
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 *
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 *
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 *
 */

public class LongestSubstringAtMostTwoDistinctCharacters {


    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));

    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[256];
        int i = 0, numDistinct = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)] == 0) numDistinct++;
            count[s.charAt(j)]++;
            while (numDistinct > 2) {
                count[s.charAt(i)]--;
                if (count[s.charAt(i)] == 0) numDistinct--;
                i++;
            }
            maxLen = Math.max(j - i + 1, maxLen);
            System.out.println(s.substring(i,j+1));
        }
        return maxLen;
    }
}
