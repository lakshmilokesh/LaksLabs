package com.amazon;

/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Input: "babad"
 *
 * Output: "bab"
 *
 * Note: "aba" is also a valid answer.
 *
 */

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println("Palindromic Substring =>  " + longestPalindromedp("bb"));
    }

    /*
     * Dynamic programming
     * time and space complexity is O(n^2)
     */
    public static String longestPalindromedp(String s) {
        String str = null;
        int maxLen = 0;
        if (s == null || s.isEmpty())
            return str;
        int len = s.length();
        boolean[][] palin = new boolean[len][len];
        for (int i = len-1; i >=0 ;i--) {
            for (int j = i; j < len ; j++) {
                if ((s.charAt(i) == s.charAt(j) && (j-i) < 2) || (s.charAt(i) == s.charAt(j) && palin[i+1][j-1])) {
                    palin[i][j] = true;
                    int temp = j-i+1;
                    if (temp > maxLen) {
                        maxLen = temp;
                        str = s.substring(i,j+1);
                    }
                }

            }
        }
        return str;                                    
    }

    public static String longestPalindrome(String s) {

        int maxLen = 0,start = 0;
        if(s.length() <= 1)
            return s;
        int len = s.length();
        for (int i = 1; i < len; i++) {
            // handles eg: sddsa
            int lo = i-1;
            int hi = i;
            while (lo >=0 && hi < len && s.charAt(lo) == s.charAt(hi)) {
                lo--;
                hi++;
            }
            int temp  = hi -lo -1;
            if(temp > maxLen) {
                maxLen = temp;

                start = lo+1;
            }

            //handles eg: asdsa
            lo = i-1;
            hi = i+1;
            while (lo >=0 && hi < len && s.charAt(lo) == s.charAt(hi)) {
                lo--;
                hi++;
            }
            temp  = hi -lo -1;
            if(temp > maxLen) {
                maxLen = temp;
                start = lo+1;
            }
        }
    return s.substring(start, start+maxLen);
    }




}
