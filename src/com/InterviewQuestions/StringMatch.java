package com.InterviewQuestions;

/**
 *     Question asked in proofpoint on  8th January 2016
 *
 *     string1  string2   Result
 *     googleMF   goe       true
 *     googleMF   geo       false
 *     googleMF   gte       false
 *     googleMF   goo       true
 */
public class StringMatch {

    public static void main(String[] args) {

        System.out.println(containsAllCharsInSameOrder("googleMF","goe"));

    }

    public static boolean containsAllCharsInSameOrder(String string1, String string2) {

        if (string1 == null || string2 == null || string2 == " ") {
            return false;
        }

        int j = 0, i = 0;
        int str2 = string2.length();
        while (i < string1.length()) {
            if (j < str2 && string1.charAt(i) == (string2.charAt(j))) {
                i++;
                j++;
                if (j == str2)
                    return true;
            } else {
                i++;
            }
        }
        return false;

    }
}