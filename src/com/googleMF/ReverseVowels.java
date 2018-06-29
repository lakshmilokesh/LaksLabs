package com.googleMF;

/*
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Given s = "hello", return "holle".
 *
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 *
 * Note:
 * The vowels does not include the letter "y".
 *
 *
 */

public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int i=0;
        int j=array.length-1;
        while(i < j) {
            while(i < j && !check(array[i])) i++;
            while(i < j && !check(array[j])) j--;
            if(i < j) {
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            i++;
            j--;
        }
        return new String(array);
    }
    public static boolean check(char c) {
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }
}
