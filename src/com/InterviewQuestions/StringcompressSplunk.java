package com.InterviewQuestions;

/*
 * Compress the given string such that the length of the compressed string is smaller than the original
 * string
 *
 * Eg : 101010111
 *
 * Solution : 101 010 111 => 527
 *
 * 2018 - Phone screen
 *
 *
 */

public class StringcompressSplunk {

    public static void main(String[] args) {

        String originalString = "101010111";
        StringBuilder compressedString = new StringBuilder();
        for (int i = 0; i< originalString.length(); i+=3) {
            compressedString.append(convertBinaryToDecimal(originalString.substring(i,i+3)));
        }
        System.out.println();
    }
    public static String convertBinaryToDecimal(String str) {
        int i = str.length()-1, j =0;
        int sum = 0;
        while (i >= 0) {
            int value = Integer.parseInt(String.valueOf(str.charAt(i)));
            sum+=value * Math.pow(2,j);
            i--;
            j++;
        }
        return String.valueOf(sum);

    }
}
